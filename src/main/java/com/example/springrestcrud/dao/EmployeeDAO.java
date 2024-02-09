package com.example.springrestcrud.dao;

import com.example.springrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    List<Employee> findAll();
}
