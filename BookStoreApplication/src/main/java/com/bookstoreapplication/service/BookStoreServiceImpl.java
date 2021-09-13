package com.bookstoreapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoreapplication.dao.BooksRepository;
import com.bookstoreapplication.model.Books;

@Service
public class BookStoreServiceImpl implements BookStoreService {
	
	@Autowired
	private BooksRepository bookRepo;

	@Override
	public void addbook(Books book) {
		// TODO Auto-generated method stub
		bookRepo.save(book);
	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		List<Books> books = bookRepo.findAll();
		return books;
	}

	@Override
	public Books getBookById(int id) {
		// TODO Auto-generated method stub
		if(bookRepo.existsById(id)) {
			return bookRepo.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		bookRepo.deleteAll();
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		if(bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return "Deletion Successfull";
		} else {
			return "Data not present";
		}
	}

	@Override
	public void UpdateBook(Books book, int id) {
		// TODO Auto-generated method stub
		Books exsbook = bookRepo.findById(id).orElse(null);
		exsbook.setBookName(book.getBookName());
		exsbook.setAuthorName(book.getAuthorName());
		exsbook.setYearPublished(book.getYearPublished());
		exsbook.setBookPrice(book.getBookPrice());
		bookRepo.save(exsbook);
	}

	@Override
	public double calcDiscount(double price) {
		// TODO Auto-generated method stub
		double disc;
		if(price < 2000)
			disc = 0.0;
		else if(price >= 2000 && price < 4000)
			disc = 0.20 * price;
		else if(price >= 4000 && price < 6000)
			disc = 0.40 * price;
		else disc = 0.60 * price;
		return disc;
	}

	@Override
	public double calcTotalPrice(int[] id) {
		// TODO Auto-generated method stub
		double total = 0.0;
		double discount;
		double totalPrice;
		List<Books> books = new ArrayList<Books>();
		for(int key : id) {
			Books book = bookRepo.findById(key).get();
			books.add(book);
		}
		for(Books book : books) {
			total += book.getBookPrice();
		}
		discount = calcDiscount(total);
		totalPrice = total - discount;
		return totalPrice;
	}

}
