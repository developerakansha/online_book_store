package com.onlinebookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinebookstore.entity.BookStoreEntity;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStoreEntity, Long>{

	@Query(name = "Select * from BOOK_DTLS where ISBN = :isbn" ,nativeQuery = true)
	List<BookStoreEntity> findByISBNCode(List<String> isbn);

}
