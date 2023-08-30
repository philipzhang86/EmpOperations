package com.curpatient.empoperations.service;

import com.curpatient.empoperations.model.Employee;
import com.curpatient.empoperations.repository.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    private EmpRepository empRepo;

    public EmpService(EmpRepository empRepo) {
        this.empRepo = empRepo;
    }

    public Employee createEmp(Employee emp) {
        return empRepo.save(emp);
    }

    public boolean existsEmp(int id){
        return empRepo.existsById(id);
    }
    public Optional<Employee> getEmpByID(int id) {
        return empRepo.existsById(id) ? empRepo.findById(id) : Optional.empty();
    }

    public Optional<Employee> getEmpByName(String name) {
        return empRepo.existsByName(name) ? empRepo.findByName(name) : Optional.empty();
    }

    public List<Employee> getAllEmp() {
        return empRepo.findAll();
    }

    public Optional<Employee> updateEmp(Employee emp) {
        if (empRepo.existsById(emp.getId())) {
            Employee updateEmp = empRepo.save(emp);
            return Optional.of(updateEmp);
        }
        return Optional.empty();
    }

    public boolean deleteEmp(int id) {
        if (empRepo.existsById(id)){
            empRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
