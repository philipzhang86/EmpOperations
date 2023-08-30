package com.curpatient.empoperations;

import com.curpatient.empoperations.model.User;
import com.curpatient.empoperations.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository repo;

    @Test
    public void test1(){
        Optional<User> opt = repo.findById(1);
        opt.ifPresent(System.out::println);
    }
}
