package com.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbo.services.UserService;
import com.dubbo.service.impl.UserServiceImpl;
import java.io.IOException;

public class ApplicationServer {
    public void openServer(Integer port) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("simple-app");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(port);
        protocolConfig.setThreads(20);

        ServiceConfig<UserService> serviceConfig = new ServiceConfig<UserService>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(new RegistryConfig(RegistryConfig.NO_AVAILABLE));
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());
        serviceConfig.export();
    }

    public static void main(String[] args) {
        ApplicationServer applicationServer = new ApplicationServer();
        applicationServer.openServer(-1);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
