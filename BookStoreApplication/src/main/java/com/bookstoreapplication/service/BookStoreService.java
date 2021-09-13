package com.bookstoreapplication.service;

import java.util.List;

import com.bookstoreapplication.model.Books;

public interface BookStoreService {
	
	public void addbook(Books book);
	public List<Books> getAllBooks();
	public Books getBookById(int id);
	public void deleteAll();
	public String deleteById(int id);
	public void UpdateBook(Books book, int id);
	public double calcDiscount(double price);
	public double calcTotalPrice(int id[]);

}
