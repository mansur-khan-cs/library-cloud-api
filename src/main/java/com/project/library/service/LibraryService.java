package com.project.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library.model.Books;
import com.project.library.repository.LibraryRepository;

@Service
public class LibraryService {
	@Autowired
	LibraryRepository repo;
	
	public List<Books> getAllBooks(){
		return (List<Books>) repo.findAll();
	}
	
	public Books getBook(int id){
		return repo.findById(id).orElse(null);
	}
	
	public void addBook(Books book) {
		repo.save(book);
	}
		
	public void deleteBook(int id) {		
		repo.deleteById(id);
	}
}
