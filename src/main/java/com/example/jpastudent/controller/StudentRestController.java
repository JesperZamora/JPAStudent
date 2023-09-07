package com.example.jpastudent.controller;

import com.example.jpastudent.model.Student;
import com.example.jpastudent.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> obj = studentRepository.findAll();
        return obj;
    }

    @GetMapping("/addStudent")
    public List<Student> addStudent() {
        Student std = new Student();
        std.setName("Jesper");
        std.setBornDate(LocalDate.now());
        std.setBornTime(LocalTime.now());
        studentRepository.save(std);

        return studentRepository.findAll();
    }


    @GetMapping("/studentss")
    public List<Student> findStudentByName(@RequestParam String name) {
        List<Student> students = studentRepository.findStudentsByName(name);
        return students;
    }


}
