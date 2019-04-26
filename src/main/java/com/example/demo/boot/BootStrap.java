package com.example.demo.boot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.example.demo.annotation.Extension;
import com.example.demo.extension.ExtensionRegister;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
public class BootStrap {
    @Getter
    @Setter
    private List<String> packages;

    @Autowired
    ExtensionRegister extensionRegister;

    public void init(){
        Set<Class<?>> classSet = scanConfiguredPackages();
        registerBeans(classSet);
    }

    private void registerBeans(Set<Class<?>> classSet) {
        for (Class<?> targetClz : classSet) {
            Extension extensionAnn = targetClz.getDeclaredAnnotation(Extension.class);
            if (extensionAnn != null) {
                extensionRegister.doRegistration(targetClz);
            }
        }
    }

    private Set<Class<?>> scanConfiguredPackages(){
        if(packages == null) {
            throw new RuntimeException("Packages is not present");
        }

        String[] pkgs = new String[packages.size()];

        ClassPathScanHandler handler = new ClassPathScanHandler(packages.toArray(pkgs));

        Set<Class<?>> classSet = new HashSet<>();
        classSet.addAll(handler.getPackageAllClasses());
        return classSet;
    }
}
