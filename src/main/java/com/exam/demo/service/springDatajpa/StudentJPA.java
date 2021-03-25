package com.exam.demo.service.springDatajpa;


import com.exam.demo.models.Student;
import com.exam.demo.repositories.StudentRepository;
import com.exam.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentJPA implements StudentService {

    private final StudentRepository studentRepository;

    public StudentJPA(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        studentRepository.findAll().forEach(list::add);
        return list;
    }


    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return studentRepository.findById(aLong);
    }

}
