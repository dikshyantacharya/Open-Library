package com.openlibrary.openlibrary.mybooks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.openlibrary.openlibrary.mybooks.entity.MyBooksEntity;

@Service
public interface MyBooksRepository extends JpaRepository<MyBooksEntity, Long> {
    @Query(value ="SELECT * FROM MY_BOOKS_ENTITY WHERE MY_BOOKS_ENTITY.PROFILE_FK = :userId", nativeQuery =true)
    List<MyBooksEntity> findAllMyBooksOfId(@Param("userId") long userId);
    
    @Query(value ="SELECT * FROM MY_BOOKS_ENTITY WHERE MY_BOOKS_ENTITY.ID = :id", nativeQuery =true)
    Optional<MyBooksEntity> findMyBooksById(@Param("id") long id);
  }