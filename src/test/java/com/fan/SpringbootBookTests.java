package com.fan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.Book;
import com.fan.entity.User;
import com.fan.mapper.BookMapper;
import com.fan.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringbootBookTests {

    @Resource
    private BookMapper bookMapper;

    @Test
    public void testInsert(){
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setAuthor("佚名");
            book.setName("朝花夕拾"+UUID.randomUUID().toString().substring(0,3));
            book.setPrice(20.00);
            book.setSales(100);
            book.setStock(500);
            bookMapper.insert(book);
        }

    }


}
