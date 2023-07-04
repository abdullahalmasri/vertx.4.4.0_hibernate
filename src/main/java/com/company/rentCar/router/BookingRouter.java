package com.company.rentCar.router;

import com.company.rentCar.model.Booking;
import com.company.rentCar.sql.BookingRepository;
import com.company.rentCar.sql.BookingRepositoryImp;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.hibernate.cfg.Configuration;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.reactive.stage.Stage;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class BookingRouter extends AbstractVerticle {

  private final BookingRepository repository;


  public BookingRouter(BookingRepository repository) {
    this.repository = repository;
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);

    router.get("/booking").handler(context -> {
//      Integer userId = Integer.valueOf(context.pathParam("userId"));
      repository.findAll()
        .onSuccess(result -> {
          JsonObject body = JsonObject.mapFrom(result);
          context.response().setStatusCode(200).end(body.encode());
        })
        .onFailure(err -> context.response().setStatusCode(500).end());
    });

    JsonObject config = config();
    Integer port = config.getInteger("port");
    server.requestHandler(router).listen(port)
      .onSuccess(result -> startPromise.complete())
      .onFailure(err -> startPromise.fail(err));

  }



    public static void main(String[] args) {
    // 1. Hibernate configuration
    Properties hibernateProps = new Properties();
    String url = "jdbc:postgresql://localhost:5432/hibernatedb";
    hibernateProps.put("hibernate.connection.url", url);
    hibernateProps.put("hibernate.connection.username", "postgres");
    hibernateProps.put("hibernate.connection.password", "postgres");
    hibernateProps.put("javax.persistence.schema-generation.database.action", "create");
    hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
    Configuration hibernateConfiguration = new Configuration();
    hibernateConfiguration.setProperties(hibernateProps);
    hibernateConfiguration.addAnnotatedClass(Booking.class);
//    hibernateConfiguration.addAnnotatedClass(Project.class);

    // 2. Session factroy
    ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
      .applySettings(hibernateConfiguration.getProperties()).build();
    Stage.SessionFactory sessionFactory = hibernateConfiguration
      .buildSessionFactory(serviceRegistry).unwrap(Stage.SessionFactory.class);

    // 3. Project repository
    BookingRepository projectRepository = new BookingRepositoryImp(sessionFactory);

    // 4. Project service
//    SimpleProjectService projectService = new SimpleProjectServiceImpl(projectRepository);

    // 5. WebVerticle
    BookingRouter verticle = new BookingRouter(projectRepository);

    DeploymentOptions options = new DeploymentOptions();
    JsonObject config = new JsonObject();
    config.put("port", 8888);
    options.setConfig(config);

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(verticle, options).onFailure(err -> err.printStackTrace())
      .onSuccess(res -> {
        System.out.println(res);
        System.out.println("Application is up and running");
      });
  }

}
