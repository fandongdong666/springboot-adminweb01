package com.fan.service.impl;

import com.fan.entity.Book;
import com.fan.mapper.BookMapper;
import com.fan.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fan
 * @since 2021-05-09
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
