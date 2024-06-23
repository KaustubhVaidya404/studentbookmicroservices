package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.BookConsumer;

@RestController
@RequestMapping("/api/v1")
public class StudentConroller {

	@Autowired
	BookConsumer consumer;
	
	@GetMapping("insert")
	public ResponseEntity<String> insert(@RequestParam("name") String name, @RequestParam("price") double price){
		return consumer.insert(name, price);
	}
}
