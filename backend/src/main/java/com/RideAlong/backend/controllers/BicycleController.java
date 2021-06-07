package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.BicycleDAO;
import com.RideAlong.backend.models.Bicycle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BicycleController {

    final private BicycleDAO bicycleDAO;

    public BicycleController(BicycleDAO bicycleDAO) {
        this.bicycleDAO = bicycleDAO;
    }

    @GetMapping("/bicycle")
    public List<Bicycle> getBicycles() {
        return bicycleDAO.getAll();
    }

    @GetMapping("/bicycle/{id}")
    public Bicycle getBicycle(@PathVariable String id) {
        Optional<Bicycle> bicycle = bicycleDAO.get(Long.parseLong(id));
        if(bicycle.isPresent())
            return bicycle.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bicycle not found");
    }

    @PostMapping("/bicycle")
    public Bicycle insertBicycle(@RequestBody Bicycle bicycle) {
        return bicycleDAO.save(bicycle);
    }

    @PutMapping("/bicycle")
    public Bicycle updateBicycle(@RequestBody Bicycle bicycle) {
        return bicycleDAO.save(bicycle);
    }

    @DeleteMapping("/bicycle/{id}")
    public Bicycle deleteBicycle(@PathVariable String id) {
        Optional<Bicycle> bicycle = bicycleDAO.get(Long.parseLong(id));
        bicycle.ifPresentOrElse(bicycleDAO::delete, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bicycle not found");
        });
        return bicycle.get();
    }
}
