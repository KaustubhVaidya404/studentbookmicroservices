package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	BookService service;

	@GetMapping("/all")
	public List<Book> gellAll() {
		List<Book> book = service.getAll();
		return book;
	}

	@GetMapping("/id")
	public Book getById(@RequestParam("id") int id) {
		Book book = service.getById(id);
		return book;
	}

	@PostMapping("/add")
	public ResponseEntity<String> insert(@RequestParam("name") String name, @RequestParam("price") double price) {
		Book book = new Book();
		book.setName(name);
		book.setPrice(price);
		
		service.insert(book);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("record inserted");
		
	}
}
