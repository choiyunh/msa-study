package com.example.discoveryservicetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceTestApplication.class, args);
    }

}
