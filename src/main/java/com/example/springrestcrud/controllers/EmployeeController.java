package com.example.springrestcrud.controllers;

import com.example.springrestcrud.dao.EmployeeDAO;
import com.example.springrestcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController
{
    private final EmployeeDAO dao;
    @Autowired
    public EmployeeController(EmployeeDAO dao) {
        this.dao = dao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return dao.findAll();
    }
}
