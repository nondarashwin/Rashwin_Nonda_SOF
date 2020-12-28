package com.manipal.demoKafka.model;

public class Book {
	private int bookId;
	private String title;
	private double price;
	private String author;
	
	public Book(int bookId, String title, double price, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
}
