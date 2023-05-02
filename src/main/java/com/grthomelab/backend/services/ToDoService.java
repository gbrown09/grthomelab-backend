package com.grthomelab.backend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.grthomelab.backend.models.ToDoModel;
import com.grthomelab.backend.repositories.ToDoRepository;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoModel> getUserTodos(String user) {
        LOG.info("Getting Todos owned by {}", user);
        return this.toDoRepository.findByUser(user);
    }

    public ToDoModel createToDo(ToDoModel toDO) {
        LOG.info("Creating todo");
        return this.toDoRepository.insert(toDO);
    }

    public ToDoModel updateToDO(ToDoModel toDO) {
        LOG.info("Updating todo");
        ToDoModel current = this.toDoRepository.findById(toDO.get_id()).get();
        current.setDone(toDO.isDone());
        current.setItem(toDO.getItem());

        return this.toDoRepository.save(current);
    }

    public void deleteToDo(String id) {
        LOG.info("Deleting todo");
        this.toDoRepository.deleteById(id);
    }

}
