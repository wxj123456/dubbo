package com.wang.dubbo.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.domain.User;
import com.dubbo.services.UserService;
import java.io.IOException;

public class DubboClient {

    static String remoteUrl = "dubbo://172.21.92.5:20880/com.dubbo.services.UserService";

    public UserService buildService(String remoteUrl) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("young-app");

        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig<UserService>();
        referenceConfig.setApplication(application);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setUrl(remoteUrl);
        UserService userService = referenceConfig.get();
        return userService;
    }

    public static void main(String[] args) {
        DubboClient dubboClient = new DubboClient();
        try {
            int read = System.in.read();
            while (System.in.read() != -1) {
                UserService userService = dubboClient.buildService(remoteUrl);
                User u = userService.getUser(111);
                System.out.println(u);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
