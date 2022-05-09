# demo-04 hello springmvc

认识 springmvc 三层架构 

了解 DispathcerServlet

## 认识 springmvc

### 什么是 MVC

* MVC 即 Model(模型), View(视图), Controller(控制器)
* MVC 是一种软件设计规范, 是一种架构模式
* MVC 是将业务逻辑, 数据, 显示分离的方法来组织代码
* MVC 的主要作用是降低了视图与业务逻辑间的耦合
 
![spring-web-model-view-controller.png](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-04/spring-web-model-view-controller.png)

在 SpringMVC 中 DispatcherServlet 类 担任 前端控制器(front controller)角色

### 职责分析

**Controller**

* 取得表单数据
* 调用业务逻辑
* 视图转换

**Model**

* 实现业务逻辑
* 数据持久化

**View**

* 显示页面

### Spring MVC

* SpringMVC 是 Spring Framework 的一部分, 是基于 Java 实现 MVC 的轻量级 Web 框架
* SpringMVC 特点

  > * 轻量级，简单易学
  > * 高效 , 基于请求响应的MVC框架
  > * 与Spring兼容性好，无缝结合
  > * 约定优于配置
  > * 功能强大：RESTful、数据验证、格式化、本地化、主题等
  > * 简洁灵活

* Spring2.5开始支持注解开发(java 5及以上)

### DispatcherServlet

* SpringMVC的Web框架围绕 DispatcherServlet **调度Servlet** 设计
* DispatcherServlet 继承自 HttpServlet, 即 DispatcherServlet 是一个 Servlet

  ![DispatcherServlet UML](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-04/dispatcherServlet_UML.png)

### SpringMVC 执行流程

**引用自 [SpringMVC Tutorial](https://www.javatpoint.com/spring-mvc-tutorial) 的流程分析**

![flow of spring web mvc](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-04/flow-of-spring-web-mvc.png)

> - As displayed in the figure, all the incoming request is intercepted by the DispatcherServlet that works as the front controller.
> - The DispatcherServlet gets an entry of handler mapping from the XML file and forwards the request to the controller.
> - The controller returns an object of ModelAndView.
> - The DispatcherServlet checks the entry of view resolver in the XML file and invokes the specified view component.

## code 

### 代码解释

详细解析请看源码注释

本项目中使用 List 模拟数据库操作, 只实现了 query 操作,通过配置 Tomcat 后再浏览器中访问即可查看结果

如访问 `localhost:8080/query/1` 将得到 json格式的字符串 `{"id":1,"name":"Eastarpen"}`

注意在 `Project Structure -> Artifacts -> WEB-INF` 目录下创建 `lib` 目录, 将项目依赖导入, 否则会报 404 错误, 完成此设置后项目编译输出的 `out` 目录格式参考下方

### 项目结构

**out目录**

```
.
└── artifacts
    └── demo_04_hello_springmvc_war_exploded
        ├── META-INF
        │   └── MANIFEST.MF
        ├── WEB-INF
        │   ├── classes
        │   │   ├── applicationContext.xml
        │   │   ├── com
        │   │   │   └── eastarpen
        │   │   │       └── demo04
        │   │   │           ├── controller
        │   │   │           │   └── HelloSpringmvcController.class
        │   │   │           ├── dao
        │   │   │           │   ├── UserDao.class
        │   │   │           │   └── UserDaoImpl.class
        │   │   │           ├── entity
        │   │   │           │   └── User.class
        │   │   │           └── service
        │   │   │               ├── UserService.class
        │   │   │               └── UserServiceImpl.class
        │   │   ├── spring-dao.xml
        │   │   ├── spring-mvc.xml
        │   │   └── spring-service.xml
        │   ├── lib
        │   │   ├── fastjson-1.2.73.jar
        │   │   ├── hamcrest-core-1.3.jar
        │   │   ├── junit-4.13.2.jar
        │   │   ├── servlet-api-2.5.jar
        │   │   ├── spring-aop-5.3.18.jar
        │   │   ├── spring-beans-5.3.18.jar
        │   │   ├── spring-context-5.3.18.jar
        │   │   ├── spring-core-5.3.18.jar
        │   │   ├── spring-expression-5.3.18.jar
        │   │   ├── spring-jcl-5.3.18.jar
        │   │   ├── spring-web-5.3.18.jar
        │   │   └── spring-webmvc-5.3.18.jar
        │   └── web.xml
        └── index.jsp
```

**src 目录**

```
.
├── main
│   ├── java
│   │   └── com
│   │       └── eastarpen
│   │           └── demo04
│   │               ├── controller
│   │               │   └── HelloSpringmvcController.java
│   │               ├── dao
│   │               │   ├── UserDao.java
│   │               │   └── UserDaoImpl.java
│   │               ├── entity
│   │               │   └── User.java
│   │               └── service
│   │                   ├── UserService.java
│   │                   └── UserServiceImpl.java
│   └── resources
│       ├── applicationContext.xml
│       ├── spring-dao.xml
│       ├── spring-mvc.xml
│       └── spring-service.xml
└── test
    └── java
```

**web目录**

```
.
├── WEB-INF
│   └── web.xml
└── index.jsp
```
