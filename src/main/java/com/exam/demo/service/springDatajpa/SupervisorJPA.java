package com.exam.demo.service.springDatajpa;

import com.exam.demo.models.Supervisor;
import com.exam.demo.service.SupervisorService;

import java.util.Optional;
import java.util.Set;

public class SupervisorJPA implements SupervisorService {
    @Override
    public Set<Supervisor> findAll() {
        return null;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return null;
    }

    @Override
    public void delete(Supervisor object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return Optional.empty();
    }
}
