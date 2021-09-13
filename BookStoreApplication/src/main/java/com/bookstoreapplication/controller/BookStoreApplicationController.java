package com.bookstoreapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreapplication.model.Books;
import com.bookstoreapplication.service.BookStoreService;

@RestController
public class BookStoreApplicationController {
	
	@Autowired
	private BookStoreService bookStoreService;
	
	@PostMapping(path = "/saveBook")
	public String saveBook(@RequestBody Books book) {
		bookStoreService.addbook(book);
		return "Entry Successfull";
	}
	
	@GetMapping(path = "/getAllBooks")
	public List<Books> getAllBooks() {
		List<Books> book = bookStoreService.getAllBooks();
		return book;
	}
	
	@GetMapping(path = "/getBook/{id}")
	public Books findBookById(@PathVariable int id) {
		Books book = bookStoreService.getBookById(id);
		return book;
	}
	
	@DeleteMapping(path = "/deleteAllBooks")
	public String deleteAllBooks() {
		bookStoreService.deleteAll();
		return "All Data Cleared Successfully";
	}
	
	@DeleteMapping(path = "/deleteBook/{id}")
	public String deleteBookById(@PathVariable int id) {
		return bookStoreService.deleteById(id);
	}
	
	@PutMapping(path = "/updateBook/{id}")
	public String updateBook(@RequestBody Books book, @PathVariable int id) {
		bookStoreService.UpdateBook(book, id);
		return "Updated Successfully";
	}
	
	@GetMapping(path = "/calcPrice/{id}")
	public double calculateTotalPrice(@PathVariable int id[]) {
		return bookStoreService.calcTotalPrice(id);
	}

}
