package com.xhc.test.springmvc.springmvc.service;

import java.util.List;

import com.xhc.test.springmvc.springmvc.domain.Book;
import com.xhc.test.springmvc.springmvc.domain.Category;

public interface BookService {

	List<Category> getAllCategories();
	Category getCategory(int id);
	List<Book> getAllBooks();
	Book save(Book book);
	Book update(Book book);
	Book get(long id);
	long getNextId();
	
}
