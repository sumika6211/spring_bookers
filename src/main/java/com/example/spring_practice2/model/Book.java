package com.example.spring_practice2.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Book {
	private int id;
	
	@NotBlank(message="タイトルを記入してください")
	private String title;
	
	@NotBlank(message="本文を入力してください")
	private String body;

	public Book(String title, String body) {
		this.title = title;
		this.body = body;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
