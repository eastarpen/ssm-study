### code

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

  ![]()

* 调用关系
  
  ![]()

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