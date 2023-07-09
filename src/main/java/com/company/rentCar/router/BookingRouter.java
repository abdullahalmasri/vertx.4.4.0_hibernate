package com.company.rentCar.router;

import com.company.rentCar.handler.BookingHandler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerFormat;
import io.vertx.ext.web.handler.LoggerHandler;

public class BookingRouter {
  private static final String APPLICATION_JSON = "application/json";
  private final BookingHandler handler;
  private final Vertx vertx;
  private HttpServer server;

  public BookingRouter(BookingHandler handler, Vertx vertx) {
    this.handler = handler;
    this.vertx = vertx;
  }

  public void setRouter(Router router) {
    router.mountSubRouter("/api/v1", buildBookRouter());
  }

  public Router buildBookRouter(){
//    HttpServer server = vertx.createHttpServer();
    final Router router = Router.router(vertx);
    router.route("/booking").handler(LoggerHandler.create());
    router.get("/booking").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(handler::readAll);
    router.get("/booking/:id").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(handler::readOne);
    router.post("/booking").consumes(APPLICATION_JSON).handler(BodyHandler.create()).handler(
      handler::create
    );
    router.put("/booking/:id").consumes(APPLICATION_JSON).handler(BodyHandler.create()).handler(
      handler::update
    );
    router.delete("/booking/:id").handler(
      handler::delete
    );
    router.get("/booking/details/:id").handler(LoggerHandler.create(LoggerFormat.DEFAULT)).handler(
      handler::getDetails
    );
    return router;

//    JsonObject config = config();
//    Integer port = config.getInteger("port");
//    server=vertx.createHttpServer()
//      .requestHandler(router);
//// Now bind the server:
//    server.listen(port, res -> {
//      if (res.succeeded()) {
//        startPromise.complete();
//      } else {
//        startPromise.fail(res.cause());
//      }
//    });
  }


//  public static void main(String[] args) {
//
//    Stage.SessionFactory emf = Persistence.createEntityManagerFactory(persistenceUnitName(args))
//      .unwrap(Stage.SessionFactory.class);
//    // 3. Project repository
//    BookingRepository projectRepository = new BookingRepositoryImp(emf);
//
//    // 4. Project service
//    BookingService projectService = new BookingServiceImp(projectRepository);
//    BookingHandler bookingHandler = new BookingHandler(projectService);
//
//    // 5. WebVerticle
//    BookingRouter verticle = new BookingRouter(bookingHandler);
//
//
////    Vertx vertx = Vertx.vertx();
////    vertx.deployVerticle(verticle, options)
////      .onFailure(err -> err.printStackTrace())
////      .onSuccess(res -> {
////        System.out.println(res);
////        System.out.println("Application is up and running");
////      });
//  }
//
//
//  /**
//   * Return the persistence unit name to use in the example.
//   *
//   * @param args the first element is the persistence unit name if present
//   * @return the selected persistence unit name or the default one
//   */
//  public static String persistenceUnitName(String[] args) {
//    return args.length > 0 ? args[0] : "postgresql-example";
//  }
//
//}

//  public static void main(String[] args) {
//    Properties hibernateProps = new Properties();
//    String url = "jdbc:postgresql://localhost:5432/hibernatedb";
//    hibernateProps.put("hibernate.connection.url", url);
//    hibernateProps.put("hibernate.connection.username", "postgres");
//    hibernateProps.put("hibernate.connection.password", "postgres");
//    hibernateProps.put("javax.persistence.schema-generation.database.action", "update");
//    hibernateProps.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
//    Configuration hibernateConfiguration = new Configuration();
//    hibernateConfiguration.setProperties(hibernateProps);
//    hibernateConfiguration.addAnnotatedClass(Booking.class);
//    hibernateConfiguration.addAnnotatedClass(Customer.class);
//    hibernateConfiguration.addAnnotatedClass(Car.class);
//
//    ServiceRegistry serviceRegistry = new ReactiveServiceRegistryBuilder()
//      .applySettings(hibernateConfiguration.getProperties()).build();
//    Stage.SessionFactory sessionFactory = hibernateConfiguration
//      .buildSessionFactory(serviceRegistry).unwrap(Stage.SessionFactory.class);
//
//    BookingRepository projectRepository = new BookingRepositoryImp(sessionFactory);
//
//    // 4. Project service
//    BookingService projectService = new BookingServiceImp(projectRepository);
//    BookingHandler bookingHandler = new BookingHandler(projectService);
//
//    // 5. WebVerticle
//    BookingRouter bookingRouter = new BookingRouter(bookingHandler, vertx);
//
//    DeploymentOptions options = new DeploymentOptions();
//    JsonObject config = new JsonObject();
//    config.put("port", 8888);
//    options.setConfig(config);
//    Vertx vertx = Vertx.vertx();
//
//    vertx.deployVerticle(bookingRouter, options)
//      .onFailure(err -> err.printStackTrace())
//      .onSuccess(res -> {
//        System.out.println(res);
//        System.out.println("Application is up and running");
//      });
//
//  }
}
