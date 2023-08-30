package com.curpatient.empoperations;

import com.curpatient.empoperations.model.Employee;
import com.curpatient.empoperations.service.EmpService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpRepoTest {
    @Autowired
    EmpService service;

    @Test
    public void test1() {
        Employee emp = new Employee();
        emp.setId(4);
        emp.setName("Jack Daniel");
        emp.setPhoneNumber("8147770000");
        emp.setSupervisors("Superman");
        service.createEmp(emp);
        Optional<Employee> opt = service.getEmpByID(4);
        if(opt.isPresent()){
            Employee temp = opt.get();
            System.out.println(temp);
        }
    }

    @Test
    public void test2(){
        List<Employee> list = service.getAllEmp();
        for(Employee e : list){
            System.out.println(e);
        }
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void test3(){
        Optional<Employee> opt = service.getEmpByName("Philip Zhang");
        if(opt.isPresent()){
            Employee temp = opt.get();
            System.out.println(temp);
        }else System.out.println("No such emp exists");
    }

    @Test
    public void test4(){
        Employee emp = new Employee();
        emp.setId(4);
        emp.setName("Jack Daniel111");
        emp.setPhoneNumber("8147770000");
        emp.setSupervisors("Superman");
        System.out.println(service.deleteEmp(emp.getId()));
    }
}
