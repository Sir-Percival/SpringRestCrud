package com.example.springrestcrud.service;

import com.example.springrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeService
{
    List<Employee> findAll();
}