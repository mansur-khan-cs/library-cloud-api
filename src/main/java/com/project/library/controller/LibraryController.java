package com.project.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.library.model.Books;
import com.project.library.service.LibraryService;

@RestController
@RequestMapping("/api/books")
public class LibraryController {
	@Autowired
	LibraryService service;
	
	@GetMapping
	public List<Books> getBooks() {		
		return service.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Books getBook(@PathVariable("id") int id) {		
		return service.getBook(id);
	}
	
	@PostMapping
	public void addBook(@RequestBody Books book) {
		service.addBook(book);
	}
	
	@PutMapping
	public void updateBook(@RequestBody Books book) {
		service.addBook(book);
	}
	
	@DeleteMapping("/{Id}")
	public void deleteBook(@PathVariable("Id") int id) {		
		service.deleteBook(id);
	}
}
