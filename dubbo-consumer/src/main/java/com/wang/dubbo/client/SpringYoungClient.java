package com.wang.dubbo.client;

import com.dubbo.services.UserService;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringYoungClient {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-consumer.xml");
        context.start();
        UserService service = context.getBean(UserService.class);
        String cmd;
        while (!"quit".equals(cmd = read())) {
            System.out.println(service.getUser(111));
        }
    }

    private static String read() throws IOException {
        byte[] b = new byte[1024];
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(System.in));
        return lineNumberReader.readLine();
    }
}
