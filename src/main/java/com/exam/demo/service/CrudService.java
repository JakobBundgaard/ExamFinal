package com.exam.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {
    List<T> findAll();
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}