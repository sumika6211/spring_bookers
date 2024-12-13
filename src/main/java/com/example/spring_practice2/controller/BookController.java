package com.example.spring_practice2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring_practice2.model.Book;
import com.example.spring_practice2.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("book") @Validated Book book, Model model) {
		bookService.create(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "index";
	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Integer bookId, Model model) {
		Book book = bookService.show(bookId);
		model.addAttribute("book", book);
		return "show";
	}
	
	@GetMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Integer bookId, Model model) {
		Book book = bookService.show(bookId);
		model.addAttribute("book", book);
		return "edit";
	}
	
	@PostMapping("books/{id}/update")
	public String update(@ModelAttribute("book") @Validated Book book, Model model) {
		bookService.update(book);
		return "redirect:/books/{id}";
	}
	
	@GetMapping("books/{id}/delete")
	public String delete(@PathVariable("id") Integer bookId) {
		bookService.delete(bookId);
		return "redirect:/books";
	}
}
