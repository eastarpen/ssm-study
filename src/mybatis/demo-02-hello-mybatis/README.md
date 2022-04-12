## hello mybatis

通过 Mybatis 实现 msql 的 CURD 基本操作

### 环境准备

1. 建立表 book 

   ```mysql
   CREATE TABLE IF NOT EXISTS `book` (
        `id` INT PRIMARY KEY AUTO_INCREMENT,
       `bookName` VARCHAR(100) NOT NULL,
       `author` VARCHAR(30) DEFAULT 'not know',
       `inventory` INT DEFAULT 0,
       `description` VARCHAR(250)
   ) ENGINE=Innodb CHARSET=utf8mb4;
   ```

2. 导入 jar 依赖

   ```xml
   <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.4.6</version>
   </dependency>

   <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
       <scope>test</scope>
   </dependency>

   <!--================-->
   <!--=====[mysql]====-->
   <!--================-->
   <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <version>8.0.12</version>
   </dependency>
   ```

   注意 mysql 的版本, 上面的适用于 mysql 8.0

### code 

**目录结构**

**HelloMybatisMapper**

接口, 定义了数据库操作方法

**HelloMybatisMapper.xml** 

对应接口的配置, 用以实现 HelloMybatisMapper.java 中的方法

**Book.java**

实体类 java bean 

所有属性皆为 private, 提供 setter/getter 和有参无参构造

**MybatisUtil.java**

根据配置文件 `mybatis-config.xml` 的信息与数据库建立连接

通过它生成的 sqlSession 与数据库交互

**db.properties**

数据库连接配置文件, 在 `mybatis-config.xml` 引用

可以选择不使用 `db.properties` 文件则 `mybatis-config.xml` 中对应的 `value` 替换为实际值

至少包含如下内容

```properties
db.url="url"
db.username="username"
db.password="password"
db.driver="driver"
```

**HelloMybatisMapperTest.java**

测试类, 测试 CURD 方法

注意增删改需要提交事务
