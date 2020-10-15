package com.openlibrary.openlibrary.availablebooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.openlibrary.openlibrary.availablebooks.entity.AvailableBooksEntity;



@Service
public interface AvailableBooksRepository extends JpaRepository<AvailableBooksEntity, Long>{
    @Query(value ="SELECT * FROM AVAILABLE_BOOKS_ENTITY WHERE AVAILABLE_BOOKS_ENTITY.PROFILE_FK <> :userId" , nativeQuery =true)
    List<AvailableBooksEntity> findAllAvailableBooksOfId(@Param("userId") long userId);

    
    @Query(value ="SELECT * FROM AVAILABLE_BOOKS_ENTITY WHERE AVAILABLE_BOOKS_ENTITY.PROFILE_FK = :userId" , nativeQuery =true)
    List<AvailableBooksEntity> findAllMyAvailableBooksOfId(Long userId);
}
