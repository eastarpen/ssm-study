package com.eastarpen.demo03;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest extends TestCase {

    public void testSayHello(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
        helloSpring.sayHello();
    }
}