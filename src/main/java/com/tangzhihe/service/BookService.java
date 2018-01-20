package com.tangzhihe.service;

import java.util.List;
import com.tangzhihe.util.Page;
import com.tangzhihe.domain.Book;
import com.tangzhihe.model.BookModel;

public interface BookService {
	public List<Book> queryBookList(Page<BookModel> page);
	
	public int save(Book Book);
	
	public int update(Book Book);
	
	public void delete(Long[] ids);
}
