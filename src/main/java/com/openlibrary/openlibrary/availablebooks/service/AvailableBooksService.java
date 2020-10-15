package com.openlibrary.openlibrary.availablebooks.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openlibrary.openlibrary.availablebooks.entity.AvailableBooksEntity;
import com.openlibrary.openlibrary.availablebooks.repository.AvailableBooksRepository;
import com.openlibrary.openlibrary.mybooks.DTO.BookDTO;
import com.openlibrary.openlibrary.mybooks.DTO.CreateBookDto;

import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;
import com.openlibrary.openlibrary.myprofile.repository.MyProfileRepository;

@Service
public class AvailableBooksService {

    @Autowired
    AvailableBooksRepository repository;
    @Autowired
    MyProfileRepository myProfileRepository;

    public List<BookDTO> findAllBooks(long userId) {
        
        List<AvailableBooksEntity> availableBooksList = repository.findAllAvailableBooksOfId(userId);
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        for(AvailableBooksEntity book: availableBooksList) {
            BookDTO bookDTO=new BookDTO(book.getId(), book.getImageUrl(), book.getBookName(), book.getBookType(), book.getAuthor(), book.getMyProfileEntity().getId());
         bookDTOList.add(bookDTO);
        }
        return  bookDTOList;
    }

    public BookDTO findBookById(long userId,long id) throws Exception {
        Optional<AvailableBooksEntity> entity = repository.findById(id);
        if(entity.isPresent()) {
         AvailableBooksEntity book =entity.get();
         BookDTO bookDTO=new BookDTO(book.getId(), book.getImageUrl(), book.getBookName(), book.getBookType(), book.getAuthor(), book.getMyProfileEntity().getId());
         return bookDTO;
        }
        else {
            throw new Exception();
        }
    }
    public AvailableBooksEntity createBook(CreateBookDto createBookDto) {
        MyProfileEntity myProfile = myProfileRepository.findById(createBookDto.getUserId()).get();
        AvailableBooksEntity availableBooksEntity = new AvailableBooksEntity();
        availableBooksEntity.setAuthor(createBookDto.getAuthor());
        availableBooksEntity.setBookName(createBookDto.getBookName());
        availableBooksEntity.setBookType(createBookDto.getBookType());
        availableBooksEntity.setImageUrl(createBookDto.getImageUrl());
     
        availableBooksEntity.setMyProfileEntity(myProfile);
        myProfile.getAvailableBooksList().add(availableBooksEntity);
        myProfileRepository.save(myProfile);
        return availableBooksEntity;
        
    }
    
    public AvailableBooksEntity updateBook(AvailableBooksEntity entity, long id) throws Exception {
        Optional<AvailableBooksEntity> toUpdateBook = repository.findById(id);
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
        Optional<AvailableBooksEntity> toDeleteBook = repository.findById(id);
        if(toDeleteBook.isPresent()) {
            repository.deleteById(id);
        }
    }

    public List<BookDTO> findAllMyAvailableBooks(Long userId) {
        List<AvailableBooksEntity> availableBooksList = repository.findAllMyAvailableBooksOfId(userId);
        List<BookDTO> bookDTOList = new ArrayList<BookDTO>();
        for(AvailableBooksEntity book: availableBooksList) {
            BookDTO bookDTO=new BookDTO(book.getId(), book.getImageUrl(), book.getBookName(), book.getBookType(), book.getAuthor(), book.getMyProfileEntity().getId());
         bookDTOList.add(bookDTO);
        }
        return  bookDTOList;
    }

    

}
