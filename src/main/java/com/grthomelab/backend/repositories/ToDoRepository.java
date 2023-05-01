package com.grthomelab.backend.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.grthomelab.backend.models.ToDoModel;

public interface ToDoRepository extends MongoRepository<ToDoModel, String> {
    List<ToDoModel> findByUser(String user);
}
