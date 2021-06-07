package com.RideAlong.backend.DAOs;

import com.RideAlong.backend.models.Bicycle;
import com.RideAlong.backend.repositories.BicycleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BicycleDAO implements DAO<Bicycle> {

    final private BicycleRepository bicycleRepository;

    public BicycleDAO(BicycleRepository bicycleRepository) {
        this.bicycleRepository = bicycleRepository;
    }

    @Override
    public Optional<Bicycle> get(long id) {
        return this.bicycleRepository.findById(id);
    }

    @Override
    public List<Bicycle> getAll() {
        return this.bicycleRepository.findAll();
    }

    @Override
    public Bicycle save(Bicycle bicycle) {
        return this.bicycleRepository.save(bicycle);
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        return this.bicycleRepository.save(bicycle);
    }

    @Override
    public Bicycle delete(Bicycle bicycle) {
        this.bicycleRepository.delete(bicycle);
        return bicycle;
    }
}
