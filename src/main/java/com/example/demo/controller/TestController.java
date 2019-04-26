package com.example.demo.controller;

import com.example.demo.extension.ExtensionExecutor;
import com.example.demo.service.Animal;
import com.example.demo.service.Cat;
import com.example.demo.service.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private ExtensionExecutor extensionExecutor;

    @GetMapping("/hi")
    public String hi(@RequestParam("code") String code){

        String result = extensionExecutor.execute(Animal.class,code ,e->e.eat());

        /*Animal animal;
        if(code.equals("cat")){
            animal = new Cat();
        }else if(code.equals("dog")){
            animal = new Dog();
        }
        String result = animal.eat();*/

        return result;
    }
}
