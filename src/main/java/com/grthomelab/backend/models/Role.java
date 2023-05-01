package com.grthomelab.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("roles")
public class Role {
    @Id
    private String id;

    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

}
