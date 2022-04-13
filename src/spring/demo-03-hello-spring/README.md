## demo-03-hello-spring

认识spring, 了解控制反转依赖注入

## 认识spring 

### 什么是 spring 

* spring 是为了解决企业级编程开发中的复杂性，实现敏捷开发的应用型框架

* spring 根据配置文件创建及组装对象之间的依赖关系

* spring 是一个容器, 方便管理配置项目

* spirng 是面向切面的

### 依赖

pom.xml 中写入

```xml 
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.18</version>
</dependency>
```

基于 maven 的特性, 它将导入spring-webmvc 与 spring-webmvc 的依赖包

### 控制反转(IOC), 依赖注入 (DI)

传统程序是由程序主动的创建对象, 获取数据, 设置属性 

Spring 容器完成了控制反转, 对象由 Spring 创建, 数据由 spring 注入, 程序只能被动的接受数据和调用完成运算

IOC 是一种思想, 是面向对象编程的法则

DI 和 IOC 是同一概念的不同描述

> “依赖注入”明确描述了“被注入对象依赖IoC容器配置依赖对象”。

通过 DI 和 IOC 能轻松设计出 **松耦合** 的程序

## code 

```shell
.
├── main
│   ├── java
│   │   └── com
│   │       └── eastarpen
│   │           └── demo03
│   │               └── HelloSpring.java
│   └── resources
│       └── applicationContext.xml
└── test
    └── java
        └── com
            └── eastarpen
                └── demo03
                    └── HelloSpringTest.java
```

**applicationContext.xml** 

spring 配置文件

**HelloSpring**

java bean 

**HelloSpringTest**

测试文件

## 推荐阅读

* [【第二章】 IoC 之 2.1 IoC基础 ——跟我学Spring3](https://www.iteye.com/blog/jinnianshilongnian-1413846)
