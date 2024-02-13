package com.example.springrestcrud.controllers;

import com.example.springrestcrud.entity.Employee;
import com.example.springrestcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController
{
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getById(@PathVariable(name = "employeeId") int id)
    {
        Employee employee = employeeService.findById(id);
        if(employee == null)
        {
            throw new RuntimeException("Employee id not found: " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        // In case of passing id in JSON we set it to 0
        // to force a save of new item instead of update
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable(name = "employeeId") int id)
    {
        Employee employee = employeeService.findById(id);
        if(employee == null)
        {
            throw new RuntimeException("Employee id not found: " + id);
        }
        employeeService.deleteById(id);
        return "Deleted employee - id: " + id;
    }
}
