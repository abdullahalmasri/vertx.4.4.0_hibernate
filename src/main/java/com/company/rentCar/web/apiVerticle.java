package com.company.rentCar.web;

import com.company.rentCar.model.Booking;
import com.company.rentCar.router.BookingRouter;
import com.company.rentCar.sql.BookingRepository;
import com.company.rentCar.sql.BookingRepositoryImp;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import org.hibernate.cfg.Configuration;
import org.hibernate.reactive.provider.ReactiveServiceRegistryBuilder;
import org.hibernate.reactive.stage.Stage;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

import static javax.persistence.Persistence.createEntityManagerFactory;

//public class apiVerticle extends AbstractVerticle {
//  private static final Logger log = LoggerFactory.getLogger(apiVerticle.class);
//
//  @Override
//  public void start(Promise<Void> promise) {
//    // 1. Hibernate configuration
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
//    Stage.SessionFactory sessionFactory = hibernateConfiguration
//      .buildSessionFactory(serviceRegistry).unwrap(Stage.SessionFactory.class);
//
//    // 3. Project repository
//    BookingRepository projectRepository = new BookingRepositoryImp(sessionFactory);
//
//    // 4. Project service
////    SimpleProjectService projectService = new SimpleProjectServiceImpl(projectRepository);
//
//    // 5. WebVerticle
////    BookingRouter verticle = new BookingRouter(repository, projectRepository);
////    final BookingRepository libraryRepository = new BookingRepositoryImp();
////    final LibraryService libraryService = new LibraryServiceImp(libraryRepository, dbClient);
////    final LibraryHandler libraryHandler = new LibraryHandler(libraryService);
////    final LibraryValidHandler libraryValidHandler = new LibraryValidHandler(vertx);
////    final LibraryRouter libraryRouter = new LibraryRouter(vertx, libraryHandler, libraryValidHandler);
////    final BookRepository bookRepository = new BookRepository();
////    final BookService bookService = new BookServiceImp(bookRepository, dbClient);
////    final BookHandler bookHandler = new BookHandler(bookService);
////    final BookValidationHandler bookValidationHandler = new BookValidationHandler(vertx);
//     BookingRouter bookRouter = new BookingRouter(projectRepository,vertx);
//
//    final Router router = Router.router(vertx);
////    ErrorHandler.buildHandler(router);
////    HealthCheckRouter.setRouter(vertx, router, dbClient);
////    MetricsRouter.setRouter(router);
//    bookRouter.setRouter(router);
////    libraryRouter.setRouter(router);
//    buildHttpServer(vertx, promise, router);
//
//  }
//
//
//  /**
//   * Run HTTP server on port 8888 with specified routes
//   *
//   * @param vertx   Vertx context
//   * @param promise Callback
//   * @param router  Router
//   */
//  private void buildHttpServer(Vertx vertx,
//                               Promise<Void> promise,
//                               Router router) {
//    final int port = 8888;
//
//    vertx.createHttpServer()
//      .requestHandler(router)
//      .listen(port, http -> {
//        log.debug("Starting HTTP server");
//        if (http.succeeded()) {
//          promise.complete();
//        } else {
//          promise.fail(http.cause());
//        }
//      });
//  }
//
//}
