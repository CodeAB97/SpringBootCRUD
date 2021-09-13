package com.bookstoreapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books {
	
	@Id
	@GeneratedValue
	private int bookId;
	private String bookName;
	private String authorName;
	private String yearPublished;
	private double bookPrice;

}
