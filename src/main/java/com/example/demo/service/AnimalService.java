package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Service("animalService")
public class AnimalService {

    public String doEat(){
        Animal animal;
        String code = "cat";
        if(code.equals("cat")){
            animal = new Cat();
        }else{
            animal = new Dog();
        }
        String eat = animal.eat();
        return eat;
    }
}
