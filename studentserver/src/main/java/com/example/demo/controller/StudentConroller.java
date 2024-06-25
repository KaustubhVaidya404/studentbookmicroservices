package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.BookConsumer;
import com.example.demo.model.Book;

@RestController
@RequestMapping("/api/v1")
public class StudentConroller {

	@Autowired
	BookConsumer consumer;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestParam("name") String name, @RequestParam("price") double price){
		return consumer.insert(name, price);
	}
	
	@GetMapping("/id")
	public Book getById(@RequestParam("id") int id) {
		return consumer.getById(id);
	}
	
	@GetMapping("/all")
	public List<Book> getAll(){
		return consumer.gellAll();
	}
}
