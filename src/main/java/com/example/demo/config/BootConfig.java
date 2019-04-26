package com.example.demo.config;

import com.example.demo.boot.BootStrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Configuration
@ComponentScan("com.example.demo.service")
public class BootConfig {
    @Bean(initMethod = "init")
    public BootStrap bootstrap() {
        BootStrap bootstrap = new BootStrap();
        List<String> packagesToScan  = new ArrayList<>();
        packagesToScan.add("com.example.demo.service");
        bootstrap.setPackages(packagesToScan);
        return bootstrap;
    }
}
