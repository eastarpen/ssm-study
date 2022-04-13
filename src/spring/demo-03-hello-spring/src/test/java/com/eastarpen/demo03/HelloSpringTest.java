package com.eastarpen.demo03;

import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest extends TestCase {

    public void testSayHello(){
        // 获取 spring 属性
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过 "helloSpring" 获取 id 为 "helloSpring" 类型为 HelloSpring 的 bean
        HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
        // 调用对象方法
        helloSpring.sayHello();
    }
}