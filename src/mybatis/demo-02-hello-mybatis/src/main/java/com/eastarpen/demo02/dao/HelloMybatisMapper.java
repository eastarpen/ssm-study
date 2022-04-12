package com.eastarpen.demo02.dao;

import com.eastarpen.demo02.entity.Book;

public interface HelloMybatisMapper {

    /**
     * 增加书籍
     * @param book
     * @return 更改的行数
     */
    public int addBook(Book book);

    /**
     * 删除书籍
     * @param id
     * @return 更改的行数
     */
    public int deleteBookById(int id);

    /**
     * 更新书籍, 通过 book 对象的 id 查询 （id 一般不允许修改）
     * @param book
     * @return 更改的行数
     */
    public int updateBookById(Book book);

    /**
     * 通过id查询
     * @param id
     * @return 更改的行数
     */
    public Book queryBookById(int id);

}
