package com.dubbo;

import java.io.IOException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSimperServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-provide.xml");
        context.start();
        System.in.read();
    }
}
