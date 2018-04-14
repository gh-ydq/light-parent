//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.light.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("springUtil")
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public SpringUtil() {
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static ApplicationContext getAppContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
}
