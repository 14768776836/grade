package com.grade.project.grade;

import com.grade.project.grade.service.MchPayOrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GradeApplicationTests {

    @Autowired
    MchPayOrderServiceImpl service;

    @Test
    public void contextLoads() {

//        MyTask myTask = new MyTask();
//        myTask.task();
        List<Integer> array = new ArrayList<>();
        array.add(5);
        service.payTest(10,array);

    }

}

