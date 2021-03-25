package com.exam.demo.controllers;

import com.exam.demo.models.Student;
import com.exam.demo.models.Supervisor;
import com.exam.demo.service.StudentService;
import com.exam.demo.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SupervisorService supervisorService;


    @GetMapping("/students")
    public Set<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/supervisors")
    public Set<Supervisor> getAllSupervisors() {
        return supervisorService.findAll();
    }

}
