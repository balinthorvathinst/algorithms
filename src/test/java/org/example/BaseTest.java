package org.example;

import org.example.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BaseTest {
    @Autowired
    protected AlgorithmService algorithmService;
} 