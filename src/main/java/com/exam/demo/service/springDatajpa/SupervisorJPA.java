package com.exam.demo.service.springDatajpa;

import com.exam.demo.models.Student;
import com.exam.demo.models.Supervisor;
import com.exam.demo.repositories.SupervisorRepository;
import com.exam.demo.service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SupervisorJPA implements SupervisorService {
    private final SupervisorRepository supervisorRepository;

    public SupervisorJPA(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }


    @Override
    public List<Supervisor> findAll() {
        List<Supervisor> list = new ArrayList<>();
        supervisorRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return supervisorRepository.save(object);
    }


    @Override
    public void delete(Supervisor object) {
        supervisorRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        supervisorRepository.deleteById(aLong);
    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return supervisorRepository.findById(aLong);
    }

}
