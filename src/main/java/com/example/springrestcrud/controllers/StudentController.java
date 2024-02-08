package com.example.springrestcrud.controllers;

import com.example.springrestcrud.entity.Student;
import com.example.springrestcrud.errors.StudentErrorResponse;
import com.example.springrestcrud.errors.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
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
        if(id >= students.size() || id < 0)
        {
            throw new StudentNotFoundException("Couldn't find student with id: " + id);
        }
        return students.get(id);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception)
    {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(LocalTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception)
    {
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimestamp(LocalTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
