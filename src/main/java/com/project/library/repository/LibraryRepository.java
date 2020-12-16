package com.project.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.library.model.Books;

@Repository
public interface LibraryRepository extends CrudRepository<Books, Integer> {

}
