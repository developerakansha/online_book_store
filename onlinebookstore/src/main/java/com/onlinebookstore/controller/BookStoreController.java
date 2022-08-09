package com.onlinebookstore.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.dto.AddBooksInStockRequestDto;
import com.onlinebookstore.dto.ResponseDto;
import com.onlinebookstore.dto.TotalAmountRequestDto;
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
		ResponseDto responseDto = new ResponseDto(); 
		try {

			if(!ObjectUtils.isEmpty(bookList)) {
				responseDto = bookStoreService.saveBookDetails(bookList);
			}
		}catch (Exception exception) {
			logger.error("Error in BookStoreController : saveBookDetails() :",exception.getMessage());
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	
	@PostMapping(value = "/totalAmountForBooks" , consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> totalAmountForBooks(@RequestBody TotalAmountRequestDto request) {
		logger.info("BookStoreController :: totalAmountForBooks() execution started");
		ResponseDto responseDto = new ResponseDto(); 
		try {

			if(!ObjectUtils.isEmpty(request)) {
				responseDto = bookStoreService.totalAmountForBooks(request);
			}
		}catch (Exception exception) {
			logger.error("Error in BookStoreController : totalAmountForBooks() :",exception.getMessage());
		}
		return ResponseEntity.status(responseDto.getStatusCode()).body(responseDto);
	}
	
	


}
