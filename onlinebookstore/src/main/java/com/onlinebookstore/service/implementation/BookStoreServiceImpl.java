package com.onlinebookstore.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.onlinebookstore.dto.AddBooksInStockRequestDto;
import com.onlinebookstore.dto.ResponseDto;
import com.onlinebookstore.dto.TotalAmountRequestDto;
import com.onlinebookstore.entity.BookStoreEntity;
import com.onlinebookstore.exception.BookStoreExcetion;
import com.onlinebookstore.repository.BookStoreRepository;
import com.onlinebookstore.service.BookStoreService;
import com.onlinebookstore.utility.Constant;
@Service
public class BookStoreServiceImpl implements BookStoreService{
	
	@Autowired
	private BookStoreRepository bookStoreRepository;

	@Override
	public ResponseDto saveBookDetails(AddBooksInStockRequestDto bookList) {
		ResponseDto responseDto = null;
		List<BookStoreEntity> list = null;
		try {
			if(!CollectionUtils.isEmpty(bookList.getBookList()))
			list = bookStoreRepository.saveAll(bookList.getBookList());
			responseDto.setResponse(list);
			responseDto.setStatus(Constant.SUCCESS);
			responseDto.setStatusMessage(Constant.SAVED_BOOKS_SUCCESSFULLY);
			responseDto.setStatusCode(HttpStatus.OK.value());
		}catch (Exception e) {
			responseDto.setStatusCode(HttpStatus.OK.value());
			throw new BookStoreExcetion("Something went wrong ,please try again later");
		}
		return responseDto;
	}

	@Override
	public ResponseDto totalAmountForBooks(TotalAmountRequestDto request) {
		List<BookStoreEntity> list = null;
		list = null;//bookStoreRepository.findByISBNCode(request.getIsbn());
		int discount = 0;
		Float totalAmount = 0f;
		Float actualPriceAfterDiscount = 0f;
		Float price = 0f;
		for(BookStoreEntity book : list) {
			price = book.getPrice();
			if(book.getDiscount().isDiscount()) {
				discount = book.getDiscount().getDiscount();
				actualPriceAfterDiscount = price - (((price)/100)*discount);
				totalAmount+=actualPriceAfterDiscount;
			}
		}
		
		
		
		return null;
	}

}
