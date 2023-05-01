package com.grthomelab.backend.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.grthomelab.backend.models.CarModel;

public interface CarRepository extends MongoRepository<CarModel, String> {
    List<CarModel> findByOwner(String owner);
}
