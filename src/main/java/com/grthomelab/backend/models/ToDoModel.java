package com.grthomelab.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Document("todo")
public class ToDoModel {

    private String _id;

    @Nullable
    private String item;

    @Nullable
    private boolean done;

    @Nullable
    private String user;

    @Nullable
    private String category;

}
