public class StorageVertical extends AbstractVerticle {
  private boolean isKafkaBusy;

  @Override
  public void start() {
    vertx.eventBus().consumer("kafka.status.request", message -> {
      // Check if Kafka is processing records
      boolean kafkaBusy = checkKafkaStatus();
      message.reply(kafkaBusy ? "busy" : "idle");
    });
  }

  private boolean checkKafkaStatus() {
    // Implement your logic to check Kafka status
    return isKafkaBusy;
  }
}
