## 带构造方法的 bean

实现对带构造方法的对象实例化

* 通过 java 反射机制实现
* 通过 cglib 实现

  需要导入依赖
  
  ```xml
  <!-- https://mvnrepository.com/artifact/cglib/cglib -->
  <dependency>
      <groupId>cglib</groupId>
      <artifactId>cglib</artifactId>
      <version>3.2.11</version>
  </dependency>
  ```
  
### code

**当前项目结构**

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── eastarpen
│   │           └── springframework
│   │               └── beans
│   │                   ├── BeansException.java
│   │                   └── factory
│   │                       ├── BeanFactory.java
│   │                       ├── config
│   │                       │   ├── BeanDefinition.java
│   │                       │   └── SingletonBeanRegistry.java
│   │                       └── support
│   │                           ├── AbstractAutowiredCapableBeanFactory.java
│   │                           ├── AbstractBeanFactory.java
│   │                           ├── BeanDefinitionRegistry.java
│   │                           ├── CglibSubclassingInstantiationStrategy.java
│   │                           ├── DefaultListableBeanFactory.java
│   │                           ├── DefaultSingletonBeanRegistry.java
│   │                           ├── InstantiationStrategy.java
│   │                           └── SimpleInstantiationStrategy.java
│   └── resources
└── test
    └── java
        └── com
            └── eatarpen
                └── springframework
                    └── test
                        ├── ApiTest.java
                        └── bean
                            └── UserService.java
```

**代码变化**

* 添加 `InstantiationStrategy` 接口及其实现
* `BeanFactory` 接口添加 `getBean` 的重载
* 细化 `getBean` 和 `createBean` 方法实现

**类图**

![strategy-UML](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-05-small-spring/note-03/strategy-UML.png)

**类设计思路**

1. `interface BeanFactory` 重载 `getBean` 方法
   
   提供获取使用有参构造实例化对象的接口

2. `interface InstantiationStrategy` 
   
   定义对象实例化规范

### 英语小课堂

* instantiation  实例化
* strategy       策略

### 推荐阅读

* [java 泛型详解](https://blog.csdn.net/s10461/article/details/53941091)

### log

* 2022-04-24 完成代码复现
* 2022-05-09 完成 `note-03` 编写