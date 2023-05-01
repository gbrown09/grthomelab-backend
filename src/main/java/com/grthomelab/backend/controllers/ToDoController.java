package com.grthomelab.backend.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grthomelab.backend.models.ToDoModel;
import com.grthomelab.backend.services.ToDoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/todo")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ToDoModel>> getTodo(@RequestParam String user) {
        List<ToDoModel> response = this.toDoService.getUserTodos(user);
        return new ResponseEntity<List<ToDoModel>>(response, HttpStatus.OK);
    }

    @PostMapping(value = "")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ToDoModel> createToDO(@RequestBody ToDoModel toDo) {
        ToDoModel response = this.toDoService.createToDo(toDo);
        return new ResponseEntity<ToDoModel>(response, HttpStatus.OK);
    }

    @PatchMapping(value = "")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ToDoModel>> updateToDo(@RequestBody List<ToDoModel> toDoList) {
        List<ToDoModel> response = new ArrayList<>();
        toDoList.forEach((toDo) -> response.add(this.toDoService.updateToDO(toDo)));
        return new ResponseEntity<List<ToDoModel>>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Map<String, String>> deleteToDo(@RequestBody List<String> toDoList) {
        toDoList.forEach((toDO) -> this.toDoService.deleteToDo(toDO));
        Map<String, String> result = new HashMap<String, String>();
        String count = String.valueOf(toDoList.size());
        result.put("message", count + " Tasks Deleted");

        return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
    }

}
