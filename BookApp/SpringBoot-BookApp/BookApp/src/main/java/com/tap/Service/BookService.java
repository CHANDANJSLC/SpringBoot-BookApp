package com.tap.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.Entity.BookEntity;
import com.tap.repo.BookRepo;

@Component
public class BookService {
	
	//2)
	
	@Autowired
	BookRepo br;
	
	//Display
	public List<BookEntity> getAllBooks() {
	 List<BookEntity> list = (List<BookEntity>) br.findAll();
	 return list;
	}

	//Fetch
	public BookEntity getBookByID(int i) {
		BookEntity b = br.findById(i);
		return b;
		
	}

	//Insert
	public String insertBook(BookEntity b) {
		br.save(b);
		return "Book Inserted";
	}
	
	//Update
	public String updateBook(int i, BookEntity b) {
	 //Got the Book from database and set to b1.
	 BookEntity b1 = br.findById(i);
	 //Get the data from old and set to new data.
	 b1.setBname(b.getBname());
	 b1.setBauthor(b.getBauthor());
		
	 br.save(b1);
	 return "Data Updated";
	}

	//Delete
	public String delete(int i) {
		br.deleteById(i);
		return "Book Deleted";
	}
}
