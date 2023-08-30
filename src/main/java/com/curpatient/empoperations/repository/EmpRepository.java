package com.curpatient.empoperations.repository;

import com.curpatient.empoperations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(int id);

    Boolean existsByName(String name);

    Optional<Employee> findByName(String name);

}
