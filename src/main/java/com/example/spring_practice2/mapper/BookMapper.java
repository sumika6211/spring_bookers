package com.example.spring_practice2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.spring_practice2.model.Book;

@Mapper
public interface BookMapper {
	List<Book> findAll();
	void create(Book book);
	Book show(Integer bookId);
	void update(Book book);
	void delete(Integer bookId);
}
