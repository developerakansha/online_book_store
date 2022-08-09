package com.onlinebookstore.service;


import com.onlinebookstore.dto.AddBooksInStockRequestDto;
import com.onlinebookstore.dto.ResponseDto;
import com.onlinebookstore.dto.TotalAmountRequestDto;
import com.onlinebookstore.entity.BookStoreEntity;

public interface BookStoreService {

	ResponseDto saveBookDetails(AddBooksInStockRequestDto bookList);

	ResponseDto totalAmountForBooks(TotalAmountRequestDto request);

	ResponseDto getBookDetailByIsbn(String isbn);

	ResponseDto deleteBookDetailByIsbn(String isbn);

	ResponseDto updateBookDetailByIsbn(BookStoreEntity request);

}
