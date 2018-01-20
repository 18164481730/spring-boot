package com.tangzhihe.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tangzhihe.domain.Book;
import com.tangzhihe.model.BookModel;
import com.tangzhihe.service.BookService;
import com.tangzhihe.util.AjaxObject;
import com.tangzhihe.util.Page;

/** 教程页面
 * Created by tengj on 2017/3/13.
 */
@Controller
@RequestMapping("/book")
public class BookController  extends AbstractController{
    @Autowired
    private BookService bookService;

    @RequestMapping("")
    public String book(Model model){
        model.addAttribute("ctx", getContextPath()+"/");
        return "book";
    }

    /**
     * 查询教程列表
     * @param page
     * @return
     */
    @RequestMapping(value = "/queryBookList",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject querybookList(Page<BookModel> page){
        List<Book> bookList=bookService.queryBookList(page);
        PageInfo<Book> pageInfo =new PageInfo<Book>(bookList);
        return AjaxObject.ok().put("page", pageInfo);
    }
    
    /**
     * 新添教程
     * @param Book
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addBook(@RequestBody Book Book) {
    	int n = bookService.save(Book);
    	if(n == 1) {
    		return AjaxObject.ok();
    	} else {
    		return AjaxObject.error();
    	}
    }
    
    /**
     * 更新教程
     * @param Book
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject updateBook(@RequestBody Book Book) {
    	int n = bookService.update(Book);
    	if(n == 1) {
    		return AjaxObject.ok();
    	} else {
    		return AjaxObject.error();
    	}
    }
    
    /**
     * 删除教程
     * @param Book
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject deleteBook(@RequestBody Long[] ids) {
    	bookService.delete(ids);
    	return AjaxObject.ok();
    }
}

















