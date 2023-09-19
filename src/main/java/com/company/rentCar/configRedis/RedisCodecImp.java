package com.company.rentCar.configRedis;

import io.lettuce.core.codec.RedisCodec;

import java.nio.ByteBuffer;

public class RedisCodecImp implements RedisCodec {
  @Override
  public Object decodeKey(ByteBuffer byteBuffer) {
    return null;
  }

  @Override
  public Object decodeValue(ByteBuffer byteBuffer) {
    return null;
  }

  @Override
  public ByteBuffer encodeKey(Object o) {
    return null;
  }

  @Override
  public ByteBuffer encodeValue(Object o) {
    return null;
  }
}
