package com.bookstoreapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstoreapplication.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
