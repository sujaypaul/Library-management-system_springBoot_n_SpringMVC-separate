package com.nagarro.training.advanceJavaAssignment5App1.model;

public class Book {

	private String code;
	private String name;
	private Author author;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(String code, String name, Author author, String date) {
		super();
		this.code = code;
		this.name = name;
		this.author = author;
		this.date = date;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
