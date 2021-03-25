package com.exam.demo.controllers;

import com.exam.demo.models.Student;
import com.exam.demo.models.Supervisor;
import com.exam.demo.service.StudentService;
import com.exam.demo.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api")
public class StudentController {


    final StudentService studentService;

    final SupervisorService supervisorService;

    @Autowired
    public StudentController(StudentService studentService, SupervisorService supervisorService) {
        this.studentService = studentService;
        this.supervisorService = supervisorService;
    }

    // get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // get all supervisors
    @GetMapping("/supervisors")
    public List<Supervisor> getAllSupervisors() {
        return supervisorService.findAll();
    }

    // Get student ID
    @GetMapping("/students/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Long studentId) {
        Optional<Student> student = studentService.findById(studentId);
        return student;
    }

    // Get supervisor by id
    @GetMapping("/supervisors/{supervisorId}")
    public Optional<Supervisor> getSupervisorById(@PathVariable Long supervisorId) {
        Optional<Supervisor> supervisor = supervisorService.findById(supervisorId);
        return supervisor;
    }

    // Create student
    @PostMapping("/newStudent")
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // Create supervisor
    @PostMapping("/newSupervisor")
    public Supervisor addSupervisor(@RequestBody Supervisor supervisor) {
        return supervisorService.save(supervisor);
    }

    // Delete student
    @DeleteMapping("/deleteStudent/{studentId}")
    void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
    }

    // Delete supervisor
    @DeleteMapping("/deleteSupervisor/{supervisorId}")
    void deleteSupervisor(@PathVariable Long supervisorId) {
        supervisorService.deleteById(supervisorId);
    }

    @PutMapping("/update/{studentId}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable Long studentId) {
        System.out.println("student to be updated" + newStudent.toString());
        return studentService.findById(studentId)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setSupervisor(newStudent.getSupervisor());
                    System.out.println("intern updated" + newStudent.toString());
                    return studentService.save(student);
                })
                .orElseGet(() -> studentService.save(newStudent));
    }
}
