package com.fan.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.Book;
import com.fan.service.IBookService;
import com.fan.service.impl.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fan
 * @since 2021-05-09
 */
@Controller
@RequestMapping("/book")
@Slf4j
public class BookController {
    @Resource
    private IBookService bookService;
    
    @GetMapping("/dynamic_table_book")
    public String dynamic_table_book(
                Model model
    ){

        List<Book> books = bookService.getBaseMapper().selectList(null);
        books.forEach(System.out::println);
        model.addAttribute("books",books);

        return "table/dynamic_table_book";
    }

    //无条件的分页查找
    @GetMapping("/dynamic_table_bookPage")
    public String dynamic_table_bookPage(
            @RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum,
            @RequestParam(defaultValue = "3",value = "pageSize")Integer pageSize,
            Model model
    ){
        if(pageNum==null || "".equals(pageNum)){
            pageNum = 1;
        }
        if(pageSize == null || "".equals(pageSize)) {
            pageSize = 3;
        }
        Page<Book> bookPage = new Page<>(pageNum, pageSize);

        System.out.println("bookPage***********"+bookPage);

        Page<Book> page = bookService.getBaseMapper().selectPage(bookPage, null);
        page.getRecords().forEach(System.out::println);

        model.addAttribute("page",page);

        return "table/dynamic_table_book";
    }

    /*价格区间的分页*/
    @GetMapping("/bookPageByPrice")
    public String bookPageByPrice(
            @RequestParam(required = true,defaultValue = "1",value = "pageNum")Integer pageNum,
            @RequestParam(defaultValue = "3",value = "pageSize")Integer pageSize,
            @RequestParam(required = false,defaultValue = "0",value = "min")Integer min,
            @RequestParam(required = false,defaultValue =Integer.MAX_VALUE+"" ,value = "max")Integer max,
            Model model
    ){
        if(pageNum==null || "".equals(pageNum)){
            pageNum = 1;
        }
        if(pageSize == null || "".equals(pageSize)) {
            pageSize = 3;
        }
        Page<Book> bookPage = new Page<>(pageNum, pageSize);
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.between("price",min,max);
        System.out.println("bookPage***********"+bookPage);

        Page<Book> page = bookService.getBaseMapper().selectPage(bookPage, wrapper);
        page.getRecords().forEach(System.out::println);
        System.out.println("总记录数：*********"+page.getTotal());
        model.addAttribute("page",page);

        return "table/dynamic_table_book";
    }
    //增加
    @PostMapping("/insertBook")
    public String insertBook(Model model,Book book,@RequestParam(required = false,value = "pageNum")Integer pageNum){
        log.info("前端参数：{}",book);
        log.info("新增的时候有页码*****：{}",pageNum);

        boolean save = bookService.save(book);
        if(save){
            return "redirect:/book/dynamic_table_bookPage?pageNum=" +(pageNum);//重新定向到查询
        }else {
        model.addAttribute("msg","添加失败");
        }

        return "table/dynamic_table_book";
    }

    //删除
    @GetMapping("/deleteById")
    public String deleteById(Model model,
                             @RequestParam(required = true,value = "id") Integer id,
                             @RequestParam(required = false,value = "pageNum") Integer pageNum

    ){
        boolean b = bookService.removeById(id);
        if(b){
            return "redirect:/book/dynamic_table_bookPage?pageNum=" +pageNum;//重新定向到查询
        }else {
            model.addAttribute("msg","删除失败");
        }
        return "table/dynamic_table_book";
    }
    //修改
    @ResponseBody
    @PostMapping("/selectById")
    public Book selectById(Model model,
                           @RequestParam(value = "id") Integer id
                           ){

        Book book = bookService.getById(id);
        System.out.println("查询回显数据^^^^^^^^^^^^："+book);
        //model.addAttribute("book",book);
        return book;
    }

    @PostMapping("/updateBook")
    public String updateBook(Model model, Book book,
                             @RequestParam(required = false,value = "pageNum") Integer pageNum){

        boolean b = bookService.updateById(book);
        System.out.println("修改：==========================="+book);

        return "redirect:/book/dynamic_table_bookPage?pageNum="+pageNum;
    }

    /**
     *
     * @param current 当前的页码
     * @param totalPage 一共多少页
     * @param navSize 需要展示的页码个数
     * @return
     */
    /*public static int[] pageNav(int current, int totalPage, int navSize){
        //算出current左边有多少个
        int before = navSize/2;

        //起始的页码，防止了起始为负数
        int start = current-before<1 ? 1 : current-before;
        //终止的页码
        int end = start+navSize-1;
        //如果终止页码大于等于总页码
        if (end>=totalPage){
            //总页码就是终止页码
            end = totalPage;
            //因为终止页码变动，起始页码也需要变动
            start = end-navSize+1;
            //如果总页码小于展示页码个数的话，起始页码可能是负数，将它变为1
            if (start<1){
                start = 1;
            }
        }

        System.out.println(start);
        System.out.println(end);

        int[] navs = new int[totalPage<navSize?totalPage:navSize];
        for (int i = start,j=0; i <= end; i++,j++) {
            navs[j] = i;
        }
        return navs;
    }*/


}
