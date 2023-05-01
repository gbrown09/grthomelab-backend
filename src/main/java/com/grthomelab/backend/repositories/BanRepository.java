package com.grthomelab.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grthomelab.backend.models.BanModel;

public interface BanRepository extends MongoRepository<BanModel, String> {
}
