## hello-springboot

### 结构

```shell 
.
├── java
│   └── com
│       └── eastarpen
│           ├── HelloSpringbootApplication.java
│           └── controller
│               └── HelloSpringBootController.java
└── resources
    ├── application.properties
    ├── static
    └── templates
```

1. resources 是 maven 资源目录, 用以存储各类配置文件
2. java 是源码目录, 存放java源码
3. `HelloSpringbootApplication.java` 是springboot的入口
4. `HelloSpringbootController.java`  控制器, 用以定义网站接口和调用业务逻辑(service)
5. controller目录必须与 `HelloSpringbootApplication.java` 同级

### 源码

**HelloSpringbootController**

```java
@RestController
public class HelloSpringBootController {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(required = false, name = "who") String who) {
        if(who == null || who.equals("")) {
            who = "World";
        }
        return String.format("Hello, %s!", who);
    }

}
```

1. `@RestController` 相当于 `@Controller, @ResponseBody` 的结合

   @Controller 告诉 Spring 这是spring的组件(Component), springboot 将自动装配

   @ResponseBody 告诉 Spring 这个类中的方法所有的返回值不经过视图解析器(ViewResolver)

2. `RequestMapping("/hello")` 该方法通过 "/hello" 触发

3. 运行程序, 通过 `localhost:8080/hello` 查看运行结果