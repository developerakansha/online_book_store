package com.onlinebookstore.dto;

import java.util.List;

public class TotalAmountRequestDto {

	private List<String> isbn;
	private String promoCode;
	
	public List<String> getIsbn() {
		return isbn;
	}
	public void setIsbn(List<String> isbn) {
		this.isbn = isbn;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	
	
	
}
