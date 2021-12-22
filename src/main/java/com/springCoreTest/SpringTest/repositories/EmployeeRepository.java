package com.springCoreTest.SpringTest.repositories;

import com.springCoreTest.SpringTest.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee>findByName(String name);
    Employee findById(Long id);
}
