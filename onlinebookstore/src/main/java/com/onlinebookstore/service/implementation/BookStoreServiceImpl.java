package com.onlinebookstore.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.onlinebookstore.dto.AddBooksInStockRequestDto;
import com.onlinebookstore.dto.ResponseDto;
import com.onlinebookstore.dto.TotalAmountRequestDto;
import com.onlinebookstore.entity.BookStoreEntity;
import com.onlinebookstore.entity.Coupon;
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
		ResponseDto responseDto = new ResponseDto();
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
		ResponseDto responseDto = new ResponseDto();
		List<BookStoreEntity> list = null;
		try {
			list = bookStoreRepository.findAllByIsbn(request.getIsbn());
		}catch (Exception e) {
			throw new BookStoreExcetion("Uable to find detail's "+e);
		}
		int discount = 0;
		Float totalAmount = 0f;
		Float actualPriceAfterDiscount = 0f;
		Float price = 0f;
		if(!CollectionUtils.isEmpty(list)) {
			for(BookStoreEntity book : list) {
				price = book.getPrice();
				if(book.getDiscount().isDiscount()) {
					discount = book.getDiscount().getDiscountPercentage();
					actualPriceAfterDiscount = price - (((price)/100)*discount);
					totalAmount+=actualPriceAfterDiscount;
				}
			}
		}
		responseDto.setResponse(totalAmount);
		responseDto.setStatus(Constant.SUCCESS);
		responseDto.setStatusMessage(Constant.TOTAL_PAYABLE_AMOUNT);
		responseDto.setStatusCode(HttpStatus.OK.value());
		return responseDto;
	}

	@Override
	public ResponseDto getBookDetailByIsbn(String isbn) {
		ResponseDto responseDto = new ResponseDto();
		BookStoreEntity bookStoreEntity = null;
		try {
			bookStoreEntity = bookStoreRepository.findByIsbn(isbn);
			if(!ObjectUtils.isEmpty(bookStoreEntity)) {
				responseDto.setResponse(bookStoreEntity);
				responseDto.setStatus(Constant.SUCCESS);
				responseDto.setStatusMessage(Constant.BOOK_DETAILS_FETCHED_SUCCESSFULLY);
				responseDto.setStatusCode(HttpStatus.OK.value());
				return responseDto;
			}
		}catch (Exception e) {
			throw new BookStoreExcetion("Uable to find detail's "+e);
		}
		return responseDto;
	}

	@Override
	public ResponseDto deleteBookDetailByIsbn(String isbn) {
		ResponseDto responseDto = new ResponseDto();
		try {
			Integer response =bookStoreRepository.updateByIsbn(isbn);
			if(response==1) {
				responseDto.setResponse(Constant.SUCCESS);
				responseDto.setStatus(Constant.SUCCESS);
				responseDto.setStatusMessage(Constant.BOOK_DETAILS_DELETED_SUCCESSFULLY);
				responseDto.setStatusCode(HttpStatus.OK.value());
				return responseDto;
			}
		}catch (Exception e) {
			throw new BookStoreExcetion("Uable to delete book detail's "+e);
		}
		return responseDto;
	}

	@Override
	public ResponseDto updateBookDetailByIsbn(BookStoreEntity request) {
		ResponseDto responseDto = new ResponseDto();
		Coupon coupon = new Coupon();
		try {
			BookStoreEntity bookStoreEntity = bookStoreRepository.findByIsbn(request.getIsbn());
			if(!ObjectUtils.isEmpty(bookStoreEntity)) {
				bookStoreEntity.setAuthor(request.getAuthor()==null?bookStoreEntity.getAuthor():request.getAuthor());
				bookStoreEntity.setBookName(request.getBookName()==null?bookStoreEntity.getBookName():request.getBookName());
				bookStoreEntity.setDescription(request.getDescription()==null?bookStoreEntity.getDescription():request.getDescription());
				bookStoreEntity.setIsAvailable(request.getIsAvailable()==null?bookStoreEntity.getIsAvailable():request.getIsAvailable());
				bookStoreEntity.setPrice(request.getPrice()==null?bookStoreEntity.getPrice():request.getPrice());
				if(!ObjectUtils.isEmpty(request.getDiscount())) {
					coupon.setDiscountPercentage(request.getDiscount().getDiscountPercentage());
					bookStoreEntity.setDiscount(coupon);
				}
				bookStoreEntity = bookStoreRepository.save(bookStoreEntity);
				if(!ObjectUtils.isEmpty(bookStoreEntity)) {
					responseDto.setResponse(Constant.SUCCESS);
					responseDto.setStatus(Constant.SUCCESS);
					responseDto.setStatusMessage(Constant.BOOK_DETAILS_UPDATED_SUCCESSFULLY);
					responseDto.setStatusCode(HttpStatus.OK.value());
					return responseDto;
				}
			}
		}catch (Exception e) {
			throw new BookStoreExcetion("Uable to delete book detail's "+e);
		}
		return responseDto;
	}


}
