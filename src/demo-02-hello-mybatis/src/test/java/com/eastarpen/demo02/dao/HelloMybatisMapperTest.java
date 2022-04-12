package com.eastarpen.demo02.dao;

import com.eastarpen.demo02.entity.Book;
import com.eastarpen.demo02.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class HelloMybatisMapperTest {

    @Test
    public void testAddBook() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        HelloMybatisMapper mapper = sqlSession.getMapper(HelloMybatisMapper.class);
        Book book = new Book(1, "test", "test", 1, "test");
        System.out.println(mapper.addBook(book));
        sqlSession.commit();
    }

    @Test
    public void testDeleteBookById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        HelloMybatisMapper mapper = sqlSession.getMapper(HelloMybatisMapper.class);
        System.out.println(mapper.deleteBookById(22));
        sqlSession.commit();
    }

    @Test
    public void testUpdateBookById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        HelloMybatisMapper mapper = sqlSession.getMapper(HelloMybatisMapper.class);
        Book book = new Book(4, "update", "test", 1, "update");
        System.out.println(mapper.updateBookById(book));
        sqlSession.commit();
    }

    @Test
    public void testQueryBookById() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        HelloMybatisMapper mapper = sqlSession.getMapper(HelloMybatisMapper.class);
        System.out.println(mapper.queryBookById(4));
    }
}