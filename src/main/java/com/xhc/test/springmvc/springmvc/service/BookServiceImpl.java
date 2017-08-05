package com.xhc.test.springmvc.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xhc.test.springmvc.springmvc.domain.Book;
import com.xhc.test.springmvc.springmvc.domain.Category;

@Service
public class BookServiceImpl implements BookService {

	
	private List<Category> categories;
	private List<Book> books;
	
	
	public BookServiceImpl() {
		categories = new ArrayList<Category>();
		Category c1 = new Category(1, "Computing");
		Category c2 = new Category(2, "Travel");
		Category c3 = new Category(3, "Health");
		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
		
		books = new ArrayList<Book>();
		books.add(new Book(1L, "9876543210", "Servlet & JSP: A Tutorial", c1, "Budi Kurniawan"));
		books.add(new Book(2L, "1112222334", "C#: A Beginner`s Tutorial", c1, "Jayden ky"));
		books.add(new Book(3L, "2244440489", "Discover China", c2, "xuhuanchao"));
	}

	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	@Override
	public Category getCategory(int id) {
		for(Category c : categories){
			if(id == c.getId()){
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		return books;
	}

	@Override
	public Book save(Book book) {
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	@Override
	public Book update(Book book) {
		int bookCount = books.size();
		for(int i=0; i<bookCount; i++){
			Book b = books.get(i);
			if(b.getId() == book.getId()){
				books.set(i, book);
				return book;
			}
		}
		return book;
	}

	@Override
	public Book get(long id) {
		for(Book b : books){
			if(id == b.getId()){
				return b;
			}
		}
		return null;
	}

	@Override
	public long getNextId() {
		long id = 0L;
		for(Book book : books){
			long bookId = book.getId();
			if(bookId > id){
				id = bookId;
			}
		}
		return id + 1;
	}

}
