package com.openlibrary.openlibrary.myprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;

@Service
public interface MyProfileRepository extends JpaRepository<MyProfileEntity, Long> {

    
}
