package com.example.demo.extension;

import com.example.demo.annotation.Extension;
import com.example.demo.service.Animal;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Component
public class ExtensionRegister implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Getter
    private Map<String, Animal> extensionRepo = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void doRegistration(Class<?> targetClz) {
        Animal extension = (Animal) applicationContext.getBean(targetClz);
        Extension extensionAnn = targetClz.getDeclaredAnnotation(Extension.class);

        extensionRepo.put(extensionAnn.code(), extension);
    }
}
