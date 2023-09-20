package com.company.rentCar.configRedis;

import com.company.rentCar.data.CarDTO;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.sentinel.RedisSentinelAsyncCommandsImpl;
import io.lettuce.core.sentinel.api.sync.RedisSentinelCommands;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.api.redisnode.RedisSentinel;
import org.redisson.client.RedisConnection;
import org.redisson.config.Config;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class redisConfig implements redisService {

//  private final RedisClient redis;
//  private final RedisSentinelCommands redis;

//  private final RLock lock;


  public redisConfig() {
    //sentinel

    /**
     * Sentinel constantly checks the master for a failure.
     * If enough sentinel agrees that the master is down then it acts as an authority
     * and will start a failover process. As a result, it will promote a replica to be the master,
     * configure other replicas to use new master until the master node is reachable again.
     * */
//    RedisCodecImp codec = new RedisCodecImp();
//    RedisURI redisUri = RedisURI.Builder
//      .sentinel("127.0.0.1", "mymaster")
//      .withSentinel("127.0.0.1").withPassword("redispassword".toCharArray()).build();
//    RedisClient client =  RedisClient.create(redisUri);
//
//    redis = client.connectSentinel(codec).sync();
    //cluster
    RedisURI node1 = RedisURI.create("172.20.0.4", 6379);
    node1.setPassword("bitnami".toCharArray());
    RedisURI node2 = RedisURI.create("172.20.0.5", 6379);
    node2.setPassword("bitnami".toCharArray());
    RedisURI node3 = RedisURI.create("172.20.0.6", 6379);
    node3.setPassword("bitnami".toCharArray());
    RedisURI node4 = RedisURI.create("172.20.0.7", 6379);
    node4.setPassword("bitnami".toCharArray());
    RedisURI node5 = RedisURI.create("172.20.0.3", 6379);
    node5.setPassword("bitnami".toCharArray());
    RedisURI node6 = RedisURI.create("172.20.0.2", 6379);
    node6.setPassword("bitnami".toCharArray());

    RedisClusterClient clusterClient = RedisClusterClient.create(Arrays.asList(node1, node2
    ,node3,node4,node5,node6));
    ClusterTopologyRefreshOptions topologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
      .enableAdaptiveRefreshTrigger(ClusterTopologyRefreshOptions.RefreshTrigger.MOVED_REDIRECT, ClusterTopologyRefreshOptions.RefreshTrigger.PERSISTENT_RECONNECTS)
      .adaptiveRefreshTriggersTimeout(Duration.ofSeconds(30))
      .build();

    clusterClient.setOptions(ClusterClientOptions.builder()
      .topologyRefreshOptions(topologyRefreshOptions)
      .build());
    StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
    RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();




//    this.lock = redisson.getLock("new-lock");
  }


  private Config setConfig() {
    // 1. Create config object
    Config config = new Config();
    config.useSingleServer()
      // use "rediss://" for SSL connection
      .setAddress("redis://127.0.0.1:6379");

    return config;
  }


  @Override
  public boolean aquire(CarDTO dto) {
    boolean check = false;


    try {
//      lock.(100,100, TimeUnit.MILLISECONDS);
//      RBucket<CarDTO> bucket = redis.getBucket("test");
//      bucket.set(dto);
      Thread.sleep(100);
      System.out.println("TIME IN MILIL IN QUEUE " + System.currentTimeMillis());
//      boolean isUpdated = bucket.compareAndSet(dto, dto);
//      CarDTO prevObject = bucket.getAndSet(dto);
//      boolean isSet = bucket.trySet(dto);
//      long objectSize = bucket.size();

      // set with expiration
//      bucket.set(dto, 3, TimeUnit.SECONDS);
//      boolean isNewSet = bucket.trySet(dto, 10, TimeUnit.SECONDS);
//      check = isNewSet;

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
//      relase();
    }

    return check;
  }

  @Override
  public void relase() {
//    if (lock.isLocked())
//      lock.unlock();
  }
}
