public class CoreVertical extends AbstractVerticle {
  @Override
  public void start() {
    vertx.setPeriodic(5000, id -> {
      vertx.eventBus().request("kafka.status.request", "", reply -> {
        if (reply.succeeded()) {
          String status = reply.result().body().toString();
          if ("busy".equals(status)) {
            vertx.eventBus().publish("kafka.status.update", "wait");
          } else {
            vertx.eventBus().publish("kafka.status.update", "proceed");
          }
        }
      });
    });
  }
}
