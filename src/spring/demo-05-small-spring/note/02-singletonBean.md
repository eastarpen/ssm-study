## SingletonBean

使用工厂模式和单例模式创建bean

tip: 代码和 `01-start` 几乎没有连系

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

  ![UML-01](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-05-small-spring/UML-02.png)

* 调用关系

  ![UML-02](https://raw.githubusercontent.com/eastarpen/ssm-study/master/img/demo-05-small-spring/UML-01.png)

**Key**

* `DefaultListableBeanFactory` 实例化的时候含有两个 `HashMap`
  
  `beanDefinitionMap` 在 `DefaultListableBeanFactory` 定义, 用以存放 bean 的注册信息

  `singletonObjects` 由 `DefaultSingletonBeanRegistry` 定义, 用以存放 单例bean 的实例

* `registerBeanDefinition` 将 bean 信息存入 注册表, 被为实例化 bean

* 第一次 `getBean` 由于容器中没有 bean 的实例, 创建实例且将其加入容器后返回容器实例

  第二次由于容器中已经存在了 bean 实例, 直接将其返回

  `getBean` 详见 `AbstractBeanFactory`
  

### 类设计思路

1. Registry -- bean 的注册与实例化
   
   为了减少资源占用, 添加到容器中的 Bean 不应该直接是实例化的对象, 于是另起一个容器存储 Bean 的注册信息(称为注册表), 注册表存放 Bean 的 class
   信息, 当 Bean 需要被实例化的时候通过class信息利用反射机制完成类实例化
   
   * `class BeanDefinition` 就是注册表中的存储单元, 每一个 BeanDefinition 则对应一个类 

   * `interface SingletonBeanRegistry` 定义了 `getSingleton` 方法, 改方法在 `getBean` 方法中被调用

   * `class defalutSingletonBeanRegistry`  实现 `interface SingletonbeanRegistry` 
    
     * 实例化容器 `singletonObjects` 用以存储 单例 bean 对象
     
     * 实现了 `getSingleton` 方法, `getSingleton` 即获取 bean 实例, 在 `getBean` 方法中被调用
       
     * 定义实现 `addSingleton` 方法, `addSingleton` 即添加 `bean` 实例, 在 `addBean` 方法中被调用
     
   注册表 `beanDefinitionMap` 在 `DefaultListableBeanFactory` 中创建

   TODO `addSingleton, getSingleton` 方法何时调用

2. Factory -- bean 的获取与创建接口 

   * `interface BeanFactory` 定义 `getBean`方法用以获取 bean 实例

   * `abstract class AbstractBeanFactory` 实现 `geetBean` 方法 并定义 `createBean, getBeanDefinition` 方法

     * `createBean` 方法用以实例化 bean
     * `getBeanDefinition` 获取 bean class 信息以实例化 bean

   * `abstract class DefaultListableBeanFactory` 实现 `createBean` 方法
    
   * `class DefaultListableBeanFactory` 实现 `getBeanDefinition`方法

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
