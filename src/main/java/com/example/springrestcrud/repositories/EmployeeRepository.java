package com.example.springrestcrud.repositories;

import com.example.springrestcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
    //http://localhost:8080/api/employees
    //http://localhost:8080/api/employees?page=1
    //http://localhost:8080/api/employees?sort=lastName
    //http://localhost:8080/api/employees?sort=lastName,firstName,desc
    //http://localhost:8080/api/employees?sort=lastName,firstName,desc&page=1
}
