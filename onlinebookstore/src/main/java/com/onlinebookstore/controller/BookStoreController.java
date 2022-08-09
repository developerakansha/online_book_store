package com.onlinebookstore.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.AddBooksInStockRequestDto;
import com.onlinebookstore.dto.ResponseDto;
import com.onlinebookstore.dto.TotalAmountRequestDto;
import com.onlinebookstore.entity.BookStoreEntity;
import com.onlinebookstore.service.BookStoreService;

@RestController
@RequestMapping(value = "/bookStore")
public class BookStoreController {

	private static final Logger logger = LoggerFactory.getLogger(BookStoreController.class);

	@Autowired
	private BookStoreService bookStoreService;

	@PostMapping(value = "/saveBookDetails")
	public ResponseEntity<Object> saveBookDetails(@RequestBody AddBooksInStockRequestDto bookList) {
		logger.info("BookStoreController :: saveBookDetails() execution started");
		ResponseDto responseDto = null; 
		if(!ObjectUtils.isEmpty(bookList)) {
			responseDto = bookStoreService.saveBookDetails(bookList);
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	
	@PostMapping(value = "/totalAmountForBooks" , consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> totalAmountForBooks(@RequestBody TotalAmountRequestDto request) {
		logger.info("BookStoreController :: totalAmountForBooks() execution started");
		ResponseDto responseDto = null;
		if(!ObjectUtils.isEmpty(request)) {
			responseDto = bookStoreService.totalAmountForBooks(request);
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	
	@GetMapping(value = "/getBookDetailByIsbn/{isbn}")
	public ResponseEntity<Object> getBookDetailByIsbn(@PathVariable("isbn") String isbn) {
		logger.info("BookStoreController :: getBookDetailByIsbn() execution started");
		ResponseDto responseDto = null; 
		if(!StringUtils.isEmpty(isbn)) {
			responseDto = bookStoreService.getBookDetailByIsbn(isbn);
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	
	//we will use soft delete ..because book may be available later
	@DeleteMapping(value = "/deleteBookDetailByIsbn/{isbn}")
	public ResponseEntity<Object> deleteBookDetailByIsbn(@PathVariable("isbn") String isbn) {
		logger.info("BookStoreController :: deleteBookDetailByIsbn() execution started");
		ResponseDto responseDto = null; 
		if(!StringUtils.isEmpty(isbn)) {
			responseDto = bookStoreService.deleteBookDetailByIsbn(isbn);
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	
	@PatchMapping(value = "/updateBookDetailByIsbn")
	public ResponseEntity<Object> updateBookDetailByIsbn(@RequestBody BookStoreEntity request) {
		logger.info("BookStoreController :: updateBookDetailByIsbn() execution started");
		ResponseDto responseDto = null; 
		if(!ObjectUtils.isEmpty(request)) {
			responseDto = bookStoreService.updateBookDetailByIsbn(request);
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	


}
