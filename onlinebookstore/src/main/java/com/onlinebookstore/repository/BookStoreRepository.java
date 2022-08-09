package com.onlinebookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.entity.BookStoreEntity;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStoreEntity, Long>{

	@Query(value = "Select * from BOOK_DTLS where ISBN IN :isbn" ,nativeQuery =true)
	List<BookStoreEntity> findAllByIsbn(List<String> isbn);

	BookStoreEntity findByIsbn(String isbn);

	@Modifying
	@Query(value = "Update BOOK_DTLS set isAvailable = 0 where ISBN =:isbn" ,nativeQuery =true)
	BookStoreEntity updateByIsbn(String isbn);

	/*
	 * @Query(name = "Select * from BOOK_DTLS where ISBN = :isbn" ,nativeQuery =
	 * true) List<BookStoreEntity> findByISBNCode(List<String> isbn);
	 */

}
