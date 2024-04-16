package com.tap.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.tap.Entity.BookEntity;

//3)

@Component
public interface BookRepo extends CrudRepository<BookEntity, Integer> {

	
	//Fetch data by Id.
	BookEntity findById(int i);
}
