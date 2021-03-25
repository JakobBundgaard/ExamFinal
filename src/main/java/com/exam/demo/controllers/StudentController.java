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


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

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

    // Create student
    @PostMapping("/newStudent")
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // Delete student
    @DeleteMapping("students/studentId")
    void deleteIntern(@PathVariable Long studentId) {
        studentService.deleteById(studentId);
    }
    /*
    // Get intern by ID
    @GetMapping("/interns/{internId}")
    public Optional<Intern> getInternById(@PathVariable Long internId){
        Optional<Intern> intern = internService.findById(internId);
        return intern;
    }

    // Create new Intern
    @PostMapping("/newIntern")
    public Intern addNewIntern(@RequestBody Intern intern){
        return internService.save(intern);
    }

    // Delete Intern
    @DeleteMapping("/interns/{internId}")
    void deleteIntern(@PathVariable Long internId){
        internService.deleteById(internId);
    }



     */

}
