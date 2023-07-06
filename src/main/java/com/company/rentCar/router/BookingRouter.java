package com.company.rentCar.router;

import com.company.rentCar.data.BookingDTO;
import com.company.rentCar.data.CustomerDTO;
import com.company.rentCar.model.Booking;
import com.company.rentCar.service.BookingService;
import com.company.rentCar.service.BookingServiceImp;
import com.company.rentCar.sql.BookingRepository;
import com.company.rentCar.sql.BookingRepositoryImp;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerFormat;
import io.vertx.ext.web.handler.LoggerHandler;
import org.hibernate.reactive.stage.Stage;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingRouter extends AbstractVerticle {
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String APPLICATION_JSON = "application/json";
//  private final BookingRepository repository;
  private final BookingService service;
  private static final String ID_PARAMETER = "id";

  public BookingRouter(BookingService service) {
//    this.repository = repository;
    this.service = service;
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    HttpServer server = vertx.createHttpServer();
    final Router router = Router.router(vertx);
    router.route("/booking").handler(LoggerHandler.create());
    router.get("/booking").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(
      routingContext -> {
        List<BookingDTO> bookingList = new ArrayList<>();
        service.findBookings().onSuccess(bookingList::addAll);
        routingContext.response()
          .setStatusCode(200)
          .putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON)
          .end(Json.encodePrettily(bookingList));
//        repository.closeFactory();
      }

    );
    router.get("/booking/:id").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(
      routingContext -> {
        final String id = routingContext.pathParam(ID_PARAMETER);
        BookingDTO bookingDTO = service.findBookingById(UUID.fromString(id)).result();
        routingContext.response()
          .setStatusCode(200)
          .putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON)
          .end(Json.encodePrettily(bookingDTO));
      }
    );
    router.post("/booking").consumes(APPLICATION_JSON).handler(BodyHandler.create()).handler(
      routingContext -> {
        BookingDTO bookingDTO =
        service.saveBooking(routingContext.body().asJsonObject().mapTo(BookingDTO.class)).result();
        routingContext.response()
          .setStatusCode(200)
          .putHeader(CONTENT_TYPE_HEADER, APPLICATION_JSON)
          .end(Json.encodePrettily(bookingDTO));
      }
    );

    JsonObject config = config();
    Integer port = config.getInteger("port");
    server.requestHandler(router).listen(port)
      .onSuccess(result -> startPromise.complete())
      .onFailure(err -> startPromise.fail(err));

  }



    public static void main(String[] args) {
      System.out.println(args);

      Stage.SessionFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName(args)).unwrap(Stage.SessionFactory.class);
//      EntityManager entityManager = emf.createEntityManager();
//      Session session = entityManager.unwrap(org.hibernate.Session.class);
//      SessionFactory factory = session.getSessionFactory();
    // 1. Hibernate configuration
//    Properties hibernateProps = new Properties();
//    String url = "jdbc:postgresql://localhost:5432/hibernatedb";
//    hibernateProps.put("hibernate.connection.url", url);
//    hibernateProps.put("hibernate.connection.username", "postgres");
//    hibernateProps.put("hibernate.connection.password", "postgres");
//    hibernateProps.put("javax.persistence.schema-generation.database.action", "create");
//    hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
//    Configuration hibernateConfiguration = new Configuration();
//    hibernateConfiguration.setProperties(hibernateProps);
//    hibernateConfiguration.addAnnotatedClass(Booking.class);
////    hibernateConfiguration.addAnnotatedClass(Project.class);
//
//    // 2. Session factroy
//    ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
//      .applySettings(hibernateConfiguration.getProperties()).build();
//
//    sessionFactory = hibernateConfiguration
//      .buildSessionFactory(serviceRegistry).unwrap(Stage.SessionFactory.class);
//
//      Configuration configuration = new Configuration();
//      configuration.configure();
//      System.out.println("the congiguration is "+sessionFactory);
    // 3. Project repository
    BookingRepository projectRepository = new BookingRepositoryImp(emf);

    // 4. Project service
    BookingService projectService = new BookingServiceImp(projectRepository);

    // 5. WebVerticle
    BookingRouter verticle = new BookingRouter(projectService);

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


  /**
   * Return the persistence unit name to use in the example.
   *
   * @param args the first element is the persistence unit name if present
   * @return the selected persistence unit name or the default one
   */
  public static String persistenceUnitName(String[] args) {
    return args.length > 0 ? args[0] : "postgresql-example";
  }

}
