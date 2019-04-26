package com.example.demo.extension;

import com.example.demo.service.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author: 徐森
 * @CreateDate: 2019/4/26
 * @Description:
 */
@Component
public class ExtensionExecutor {
    @Autowired
    private ExtensionRegister extensionRegister;

    public <R, T> R execute(Class<T> targetClz, String bizCode, Function<T, R> exeFunction) {
        //T component = locateComponent(targetClz, bizCode);
        T component = locateComponent(bizCode);
        return exeFunction.apply(component);
    }

    protected <C> C locateComponent(Class<C> targetClz, String bizCode) {
        C extension = locateExtension(targetClz, bizCode);
        return extension;
    }
    protected <C> C locateComponent(String bizCode) {
        C extension = locateExtension(bizCode);
        return extension;
    }
    protected <Ext> Ext locateExtension(Class<Ext> targetClz, String bizCode) {
        Ext extension;

        // first try
        extension = (Ext)extensionRegister.getExtensionRepo().get(bizCode);
        if (extension != null) {
            return extension;
        }

        throw new RuntimeException("Can not find extension with ExtensionPoint: "+targetClz+" BizCode:"+bizCode);
    }
    protected <Ext> Ext locateExtension(String bizCode) {
        Ext extension;

        // first try
        extension = (Ext)extensionRegister.getExtensionRepo().get(bizCode);
        if (extension != null) {
            return extension;
        }

        throw new RuntimeException("Can not find extension with BizCode:"+bizCode);
    }
}
