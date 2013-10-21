package com.parsexml.w3c.dom.student.test;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private String id ;
	private String name;
	private Map<String,Book> books = new HashMap<String,Book>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Book> getBooks() {
		return books;
	}
	public void setBooks(Map<String, Book> books) {
		this.books = books;
	}
}
