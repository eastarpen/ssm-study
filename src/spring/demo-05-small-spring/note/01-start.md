## start

本部分对应 [《Spring 手撸专栏》第 2 章：小试牛刀，实现一个简单的Bean容器！](https://mp.weixin.qq.com/s/fiWX6abSCiUKHAUa-HKg4A)

### 解释 

构建 spring 的基础 `BeanDefinition.java` 和 `BeanFactory.java`

1. `BeanDefinition.java` 用以定义 bean
2. `BeanFactory.java` 用以存储 bean

现在我们只是使用了一个 hash map 存储对象

### code

**当前项目源码结构**

```shell
src
├── main
│   ├── java
│   │   └── com
│   │       └── eastarpen
│   │           └── springframework
│   │               ├── BeanDefinition.java
│   │               └── BeanFactory.java
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

**源码**

1. `BeanDefinition.java`

   ```java
   package com.eastarpen.springframework;
   
   public class BeanDefinition {
   
       private Object bean;
   
       public BeanDefinition(Object bean) {
           this.bean = bean;
       }
   
       public void setBean(Object bean) {
           this.bean = bean;
       }
   
       public Object getBean() {
           return bean;
       }
   }
   ```

2. `BeanFactory.java`   
   
   ```java
   package com.eastarpen.springframework;
   
   import java.util.Map;
   import java.util.concurrent.ConcurrentHashMap;
   
   public class BeanFactory {
   
       private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
   
       public Object getBean(String name) {
           return beanDefinitionMap.get(name).getBean();
       }
   
       public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
           beanDefinitionMap.put(name, beanDefinition);
       }
   }
   
   ```
   
3. `UserService.java`

   ```java
   package com.eatarpen.springframework.test.bean;
   
   public class UserService {
       public void run() {
           System.out.println("UserService run");
       }
   }
   ```

4. `ApiTest.java`

   ```java
   package com.eatarpen.springframework.test;
   
   import com.eastarpen.springframework.BeanDefinition;
   import com.eastarpen.springframework.BeanFactory;
   import com.eatarpen.springframework.test.bean.UserService;
   import org.junit.Test;
   
   public class ApiTest {
   
       @Test
       public void testBeanFactory() {
           // 实例化工厂
           BeanFactory beanFactory = new BeanFactory();
   
           // 注册 bean
           beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));
   
           // 获取 bean
           UserService userService = (UserService)beanFactory.getBean("userService");
   
           // 调用 bean 方法
           userService.run();
       }
   }

   ```

### log

* 2022-04-20 完成代码复现和测试