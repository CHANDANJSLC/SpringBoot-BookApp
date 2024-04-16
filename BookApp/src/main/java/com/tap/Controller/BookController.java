package com.tap.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tap.Entity.BookEntity;
import com.tap.Service.BookService;

@RestController
public class BookController {
	
	//1)
	
	@Autowired
	BookService bs;

	//Get(Display all datas in database).
	@GetMapping("/books")
	public List<BookEntity> getAllBooks() {
		return bs.getAllBooks();	
	}
	
	//http://localhost:8080/books/2
	//Fetch the data by id(Put id in url which data you have to fetch)in Postman.
	@GetMapping("/books/{id}")
	public BookEntity getBookByID(@PathVariable("id") int i) {
		return bs.getBookByID(i); 
	}
	
	//Insert the Book(Post mapping) in the body in POSTMAN API.
	@PostMapping("/books")
	public String insertBook(@RequestBody BookEntity b) {
		return bs.insertBook(b);
	}
	
	//Update the data(Put mapping)
	//Consider path variable(url(put the id which has to be updated)) and Change it in POSTMAN body.
	@PutMapping("/books/id")
	public String updateBook(@RequestBody BookEntity b, @PathVariable("id") int i) {
		return bs.updateBook(i,b);
	}
	
	//Delete by id
	@DeleteMapping("/books/id")
	public String deleteBook(@PathVariable("id")int i,@RequestParam BookEntity b) {
		return bs.delete(i);
	}
	
	
}
