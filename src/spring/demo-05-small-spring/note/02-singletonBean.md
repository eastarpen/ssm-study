## SingletonBean

使用工厂模式和单例模式创建bean

### code

代码详细解释见注释

**当前项目结构**

```shell
❯ tree src
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
│   │                           ├── DefaultListableBeanFactory.java
│   │                           └── DefaultSingletonBeanRegistry.java
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

**类图**

* 继承/实现 关系

  ![UML-01](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-05-small-spring/UML-01.png)

* 调用关系

  ![UML-02](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-05-small-spring/UML-02.png)

**Key**

* `DefaultListableBeanFactory` 实例化的时候含有两个 `HashMap`
  
  `beanDefinitionMap` 在 `DefaultListableBeanFactory` 定义, 用以存放 bean 的注册信息

  `singletonObjects` 由 `DefaultSingletonBeanRegistry` 定义, 用以存放 单例bean 的实例

* `registerBeanDefinition` 将 bean 信息存入 注册表, 被为实例化 bean

* 第一次 `getBean` 由于容器中没有 bean 的实例, 创建实例且将其加入容器后返回容器实例

  第二次由于容器中已经存在了 bean 实例, 直接将其返回

  `getBean` 详见 `AbstractBeanFactory`
  

TODO 各个类的具体职责

### `@SuppressWarnings({"rawtypes})`

`@SuppressWarnings` 使编译器编译时不输出某些警告

rawtypes 正在使用原始类型

List、Set、Map是Java中的原始数据类型，Java 5出现泛型，现已不推荐使用原始类型，更推荐使用泛型例如：List<?>、Set<?>、Map<?>，原因以下：

* 使用原始数据类型从集合中读取到的每一个对象都必须进行转换，如果有人不小心插入了类型错误的对象，在运行时转换就会出错。
* 使用泛型可以告诉编译器每个集合中接受哪些对象类型，编译器自动为插入进行转换，并在编译时告知是否插入错误类型的对象
* 使用泛型的优点：使程序更安全，更清楚。

### 英语小课堂

* singleton 单例
* autowire  自动装配
* suppress  抑制, 镇压

### log

* 2022-04-21 完成 [《Spring 手撸专栏》第 3 章：初显身手，运用设计模式，实现 Bean 的定义、注册、获取](https://mp.weixin.qq.com/s/CgvQzm8B-CvQvXdxONC-lA) 的复现
* 2022-04-22 完成 `02-singletonBean.md` 的编写, uml图绘制 和代码注释 
* 2022-04-23 优化注解
