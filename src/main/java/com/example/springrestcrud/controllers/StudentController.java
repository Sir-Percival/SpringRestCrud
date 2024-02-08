package com.example.springrestcrud.controllers;

import com.example.springrestcrud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController
{
    private final List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student("John", "Smith", 22));
        students.add(new Student("Diana", "Louis", 21));
        students.add(new Student("Tim", "Bolton", 23));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable(name = "studentId") int id)
    {
        return students.get(id);
    }
}
