package com.company.rentCar.configRedis;

import com.company.rentCar.data.CarDTO;

public interface redisService {


  boolean aquire(CarDTO dto);

  void relase();
}
