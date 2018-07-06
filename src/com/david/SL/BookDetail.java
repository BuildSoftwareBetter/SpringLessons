package com.david.SL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 注解设置自动扫描组件，并设置组件名称
@Component("bookDetail")
public class BookDetail {


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // 使用EL设置属性值
    @Value("#{bookBean}")
    private Book book;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    // 使用EL设置属性值
    @Value("#{bookBean.getFullName('v1.0 ')}")
    private String bookName;

    @Override
    public String toString()    {
        return this.bookName;
    }
}
