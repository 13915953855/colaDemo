package com.example.demo;

import com.example.demo.config.BootConfig;
import com.example.demo.extension.ExtensionExecutor;
import com.example.demo.service.Animal;
import com.example.demo.service.AnimalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BootConfig.class})
public class AnimalTest {

    @Autowired
    private ExtensionExecutor extensionExecutor;

    @Test
    public void test(){
        //ExtensionExecutor extensionExecutor = new ExtensionExecutor();
        String s = extensionExecutor.execute(Animal.class,"Dog",e -> e.eat());
        System.out.println(s);
    }
}
