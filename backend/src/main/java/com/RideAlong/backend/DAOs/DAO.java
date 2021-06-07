package com.RideAlong.backend.DAOs;

import java.util.List;
import java.util.Optional;

interface DAO<T> {

    Optional<T> get(long id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    T delete(T t);
}