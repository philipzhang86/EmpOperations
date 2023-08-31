package com.curpatient.empoperations.controller;

import com.curpatient.empoperations.model.Employee;
import com.curpatient.empoperations.service.EmpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/employees")
public class EmpController {
    private final EmpService empService;

    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping//conventional RESTful approach: Use the HTTP POST method to /api/employees.
    public ResponseEntity<Employee> createEmp(@RequestBody Employee emp) {
        Employee createdEmp = empService.createEmp(emp);
        return ResponseEntity.ok(createdEmp);
    }

    @GetMapping("/{id}")//lambda expression in java 17 会增加编译负担吗？底层编译原理是？
    public ResponseEntity<Employee> getEmpByID(@PathVariable int id) {
        Optional<Employee> employeeOpt = empService.getEmpByID(id);
        if (employeeOpt.isPresent()) {
            return ResponseEntity.ok(employeeOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmp() {
        List<Employee> employees = empService.getAllEmp();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> getEmpByName(@PathVariable String name) {
        Optional<Employee> employeeOpt = empService.getEmpByName(name);

        if (employeeOpt.isPresent()) {
            return ResponseEntity.ok(employeeOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable int id, @RequestBody Employee emp) {
        if (id != emp.getId()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Employee> updatedEmpOpt = empService.updateEmp(emp);
        if (updatedEmpOpt.isPresent()) {
            return ResponseEntity.ok(updatedEmpOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmp(@PathVariable int id) {
        if (empService.deleteEmp(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
