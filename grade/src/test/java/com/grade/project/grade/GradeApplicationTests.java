package com.grade.project.grade;

import com.grade.project.grade.service.MchPayOrderServiceImpl;
import com.grade.project.grade.task.MyTask;
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

    }

}

