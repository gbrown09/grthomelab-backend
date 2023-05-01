package com.grthomelab.backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document("cars")
public class CarModel {

    private String owner;

    private int year;

    private String make;

    private String model;

}
