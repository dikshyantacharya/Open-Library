package com.openlibrary.openlibrary.availablebooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.openlibrary.openlibrary.availablebooks.entity.AvailableBooksEntity;


@Service
public interface AvailableBooksRepository extends JpaRepository<AvailableBooksEntity, Long>{

}
