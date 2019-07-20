package com.hzero.demo;

import org.hzero.autoconfigure.imported.EnableHZeroImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableHZeroImport
@EnableEurekaClient
@SpringBootApplication
public class HzeroImportDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(HzeroImportDemoApplication.class, args);
    }
}
