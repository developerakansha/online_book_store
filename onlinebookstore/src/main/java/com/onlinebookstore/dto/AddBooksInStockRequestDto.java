package com.onlinebookstore.dto;

import java.util.List;

import com.onlinebookstore.entity.BookStoreEntity;

public class AddBooksInStockRequestDto {

	private List<BookStoreEntity> bookList;

	public List<BookStoreEntity> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookStoreEntity> bookList) {
		this.bookList = bookList;
	}
	
	
}
