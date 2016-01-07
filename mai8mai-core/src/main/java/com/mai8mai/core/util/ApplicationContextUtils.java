package com.mai8mai.core.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextUtils {
    private static ApplicationContext context;

    static {
        if(context==null){
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
    }

    public static Object getBean(Class classz) {
        return context.getBean(classz);
    }
}