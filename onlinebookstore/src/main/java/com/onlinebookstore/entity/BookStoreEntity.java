package com.onlinebookstore.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOK_DTLS" ,schema = "onlinebookstore")
@AllArgsConstructor
@NoArgsConstructor
public class BookStoreEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private Long bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "BOOK_TYPE")
	private String type;
	
	@Column(name = "PRICE")
	private Float price;
	
	@Column(name = "ISBN" , unique = true)
	private String isbn;
	
	@Transient
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private Coupon discount;
	
	@Column(name = "is_available")
	private Boolean isAvailable=true;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Coupon getDiscount() {
		return discount;
	}

	public void setDiscount(Coupon discount) {
		this.discount = discount;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	
}
