import io.vertx.core.Vertx;
import io.vertx.kafka.client.consumer.KafkaConsumer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ConsumerGroupDescription;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.MemberDescription;
import org.apache.kafka.clients.admin.DescribeConsumerGroupsResult;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

  public class KafkaStatusChecker {

    private final Vertx vertx;
    private final String bootstrapServers;
    private final String consumerGroupId;

    public KafkaStatusChecker(Vertx vertx, String bootstrapServers, String consumerGroupId) {
      this.vertx = vertx;
      this.bootstrapServers = bootstrapServers;
      this.consumerGroupId = consumerGroupId;
    }

    public boolean checkKafkaStatus() {
      try (AdminClient adminClient = KafkaAdminClient.create(Collections.singletonMap("bootstrap.servers", bootstrapServers))) {
        DescribeConsumerGroupsResult result = adminClient.describeConsumerGroups(Collections.singletonList(consumerGroupId));
        ConsumerGroupDescription description = result.describedGroups().get(consumerGroupId).get();

        // Check if there are active members in the consumer group
        boolean isKafkaBusy = description.members().stream()
          .map(MemberDescription::assignment)
          .anyMatch(assignment -> !assignment.partitions().isEmpty());

        return isKafkaBusy;
      } catch (ExecutionException | InterruptedException e) {
        e.printStackTrace();
        return false;
      }
    }
  }


