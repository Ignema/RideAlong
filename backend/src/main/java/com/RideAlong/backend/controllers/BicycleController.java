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

    @GetMapping("/bicycle/user/{id}")
    public List<Bicycle> getUserBicycles(@PathVariable String id) {
        return bicycleDAO.getUserBicycles(Long.parseLong(id));
    }

    @GetMapping("/bicycle/owner/{id}")
    public List<Bicycle> getUserOrganizedBicycles(@PathVariable String id) {
        return bicycleDAO.getUserOwnedBicycles(Long.parseLong(id));
    }

    @GetMapping("/bicycle/{bicycle_id}/user/{user_id}")
    public Boolean isUseOwnerOrRenter(@PathVariable String bicycle_id, @PathVariable String user_id) {
        return bicycleDAO.isUseOwnerOrRenter(Long.parseLong(bicycle_id), Long.parseLong(user_id));
    }

    @PostMapping("/bicycle")
    public Bicycle insertBicycle(@RequestBody Bicycle bicycle) {
        return bicycleDAO.save(bicycle);
    }

    @PostMapping("/bicycle/{bicycle_id}/user/{user_id}")
    public Bicycle rentBicycle(@PathVariable String bicycle_id, @PathVariable String user_id) {
        return bicycleDAO.rentBicycle(Long.parseLong(bicycle_id), Long.parseLong(user_id));
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
