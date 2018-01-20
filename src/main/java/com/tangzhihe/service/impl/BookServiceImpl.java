package com.tangzhihe.service.impl;

import java.util.List;
import java.util.Arrays;
import com.tangzhihe.util.Page;
import com.tangzhihe.domain.Book;
import com.tangzhihe.dao.BookDao;
import com.tangzhihe.model.BookModel;
import com.tangzhihe.service.BookService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao  BookDao;

    @Override
    public List<Book> queryBookList(Page<BookModel> page) {
        PageHelper.startPage(page.getPage(), page.getRows());
        BookModel BookModel = new BookModel();
        return BookDao.queryBookList(BookModel);
    }

	@Override
	public int save(Book Book) {
		return BookDao.insertByBook(Book);
	}

	@Override
	public int update(Book Book) {
		return BookDao.updateByBook(Book);
	}

	@Override
	public void delete(Long[] ids) {
		 Arrays.stream(ids).forEach(id->BookDao.deleteByBook(id));
	}
}
