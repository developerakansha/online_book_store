package com.onlinebookstore.service;


import com.onlinebookstore.dto.AddBooksInStockRequestDto;
import com.onlinebookstore.dto.ResponseDto;
import com.onlinebookstore.dto.TotalAmountRequestDto;

public interface BookStoreService {

	ResponseDto saveBookDetails(AddBooksInStockRequestDto bookList);

	ResponseDto totalAmountForBooks(TotalAmountRequestDto request);

	ResponseDto getBookDetailByIsbn(String isbn);

	ResponseDto deleteBookDetailByIsbn(String isbn);

}
