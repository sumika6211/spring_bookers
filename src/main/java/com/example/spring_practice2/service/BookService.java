package com.example.spring_practice2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_practice2.mapper.BookMapper;
import com.example.spring_practice2.model.Book;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	
	@Transactional
	public List<Book> findAll(){
		return bookMapper.findAll();
	}
	
	@Transactional
	public void create(Book book){
		bookMapper.create(book);
	}
	
	@Transactional
	public Book show(Integer bookId) {
		return bookMapper.show(bookId);
	}
	
	@Transactional
	public void update(Book book) {
		bookMapper.update(book);
	}
	
	@Transactional
	public void delete(Integer bookId) {
		bookMapper.delete(bookId);
	}
}
