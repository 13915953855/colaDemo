package com.example.demo.boot;

import com.example.demo.annotation.Extension;
import lombok.Getter;
import lombok.Setter;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
public class ClassPathScanHandler {
    /**
     * the reflections.
     */
    @Getter
    @Setter
    private Reflections reflections = null;

    public ClassPathScanHandler(String... packages){
        this.reflections = new Reflections(new ConfigurationBuilder().forPackages(packages)
        .addScanners(new TypeAnnotationsScanner(),new SubTypesScanner()));
    }

    public Set<Class<?>> getPackageAllClasses() {
        return this.reflections.getTypesAnnotatedWith(Extension.class);
    }
}
