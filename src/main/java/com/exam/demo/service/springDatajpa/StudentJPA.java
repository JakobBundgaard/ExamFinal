package com.exam.demo.service.springDatajpa;


import com.exam.demo.models.Student;
import com.exam.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StudentJPA implements StudentService {
    @Override
    public Set<Student> findAll() {
        return null;
    }

    @Override
    public Student save(Student object) {
        return null;
    }

    @Override
    public void delete(Student object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }
}
