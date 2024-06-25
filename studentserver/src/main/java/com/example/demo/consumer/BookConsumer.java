package com.example.demo.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Book;

@FeignClient(name = "bookserver", path="/api/v1")
public interface BookConsumer {

	
	@GetMapping("/all")
	public List<Book> gellAll();

	@GetMapping("/id")
	public Book getById(@RequestParam("id") int id);

	@PostMapping("/add")
	public ResponseEntity<String> insert(@RequestParam("name") String name, @RequestParam("price") double price);
}
