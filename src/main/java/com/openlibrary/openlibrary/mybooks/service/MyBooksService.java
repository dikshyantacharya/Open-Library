package com.openlibrary.openlibrary.mybooks.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.openlibrary.openlibrary.mybooks.DTO.BookDTO;
import com.openlibrary.openlibrary.mybooks.DTO.CreateBookDto;

import com.openlibrary.openlibrary.mybooks.entity.MyBooksEntity;
import com.openlibrary.openlibrary.mybooks.repository.MyBooksRepository;
import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;
import com.openlibrary.openlibrary.myprofile.repository.MyProfileRepository;

@Service

public class MyBooksService {

    @Autowired
    MyBooksRepository repository;
    
    @Autowired
    MyProfileRepository myProfileRepository;
    
    public List<BookDTO> findAllMyBooks(long userId){
        List<MyBooksEntity> myBooksList = repository.findAllMyBooksOfId(userId);
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        for(MyBooksEntity book: myBooksList) {
            BookDTO bookDTO=new BookDTO(book.getId(), book.getImageUrl(), book.getBookName(), book.getBookType(), book.getAuthor(), book.getMyProfileEntity().getId());
         bookDTOList.add(bookDTO);
        }
        return  bookDTOList;
    }
    
    public BookDTO findById(long id) throws Exception {
        Optional<MyBooksEntity> entity = repository.findById(id);
        if(entity.isPresent()) {
         MyBooksEntity book =entity.get();
         BookDTO bookDTO=new BookDTO(book.getId(), book.getImageUrl(), book.getBookName(), book.getBookType(), book.getAuthor(), book.getMyProfileEntity().getId());
         return bookDTO;
        }
        else {
            throw new Exception();
        }
     
    }
    
    
    public MyBooksEntity createMyBooks(CreateBookDto createBookDto) {
        MyProfileEntity myProfile = myProfileRepository.findById(createBookDto.getUserId()).get();
        MyBooksEntity myBookEntity = new MyBooksEntity();
        myBookEntity.setAuthor(createBookDto.getAuthor());
        myBookEntity.setBookName(createBookDto.getBookName());
        myBookEntity.setBookName(createBookDto.getBookType());
        myBookEntity.setImageUrl(createBookDto.getImageUrl());
     
        myBookEntity.setMyProfileEntity(myProfile);
        myProfile.getMyBooksList().add(myBookEntity);
        myProfileRepository.save(myProfile);
        return myBookEntity;
    }
    
    public MyBooksEntity updateMyBooks(MyBooksEntity entity, long id) throws Exception {
        Optional<MyBooksEntity> toUpdateBook = repository.findById(id);
        if(toUpdateBook.isPresent()) {
            toUpdateBook.get().setAuthor(entity.getAuthor());
            toUpdateBook.get().setBookName(entity.getBookName());
            toUpdateBook.get().setBookType(entity.getBookType());
            toUpdateBook.get().setImageUrl(entity.getImageUrl());
            repository.save(toUpdateBook.get());
            return toUpdateBook.get();
         
        }
        else {
            throw new Exception();
        }
       
       
    }
    
    public void deleteBookById(long id) {
     Optional<MyBooksEntity> toDeleteEntity = repository.findById(id);
     if(toDeleteEntity.isPresent()) {
         repository.deleteById(id);
     }
    }
}
