package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

	@Autowired
	BookRepository repo;
	
	public void insert(Book book) {
		repo.save(book);
	}
	
	public Book getById(int id) {
		Book book = repo.findById(id).get();
		return book;
	}
	
	public List<Book> getAll(){
		List<Book> book = repo.findAll();
		return book;
	}
	
}
