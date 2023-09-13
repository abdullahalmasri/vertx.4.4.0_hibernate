package com.company.rentCar.configRedis;

import com.company.rentCar.data.CarDTO;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class redisConfig implements redisService {

  private final RedissonClient redisson;
  private final RLock lock;


  public redisConfig() {
    this.redisson = Redisson.create(setConfig());
    this.lock = redisson.getLock("new-lock");
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
      lock.tryLock(100,100, TimeUnit.MILLISECONDS);
      RBucket<CarDTO> bucket = redisson.getBucket("test");
      bucket.set(dto);
      Thread.sleep(100);
      System.out.println("TIME IN MILIL IN QUEUE " + System.currentTimeMillis());
//      boolean isUpdated = bucket.compareAndSet(dto, dto);
//      CarDTO prevObject = bucket.getAndSet(dto);
//      boolean isSet = bucket.trySet(dto);
//      long objectSize = bucket.size();

      // set with expiration
//      bucket.set(dto, 3, TimeUnit.SECONDS);
      boolean isNewSet = bucket.trySet(dto, 10, TimeUnit.SECONDS);
      check = isNewSet;

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
//      relase();
    }

    return check;
  }

  @Override
  public void relase() {
    if (lock.isLocked())
      lock.unlock();
  }
}
