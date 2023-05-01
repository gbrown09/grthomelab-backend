package com.grthomelab.backend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.grthomelab.backend.models.CarModel;
import com.grthomelab.backend.repositories.CarRepository;

@Service
public class CarService {
    private final CarRepository carRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarModel> getAllCars() {
        LOG.info("Getting All Cars");
        return carRepository.findAll();
    }

    public List<CarModel> getAllOwnerCars(String owner) {
        LOG.info("Getting All Cars owned by {}", owner);
        return carRepository.findByOwner(owner);
    }

}
