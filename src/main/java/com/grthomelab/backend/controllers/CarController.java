package com.grthomelab.backend.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grthomelab.backend.models.CarModel;
import com.grthomelab.backend.services.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CarModel> getAllCars() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/{owner}", method = RequestMethod.GET)
    public List<CarModel> getOwnersCars(@PathVariable String owner) {
        return carService.getAllOwnerCars(owner);
    }
}
