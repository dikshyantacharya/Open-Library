package com.openlibrary.openlibrary.availablebooks.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openlibrary.openlibrary.availablebooks.entity.AvailableBooksEntity;
import com.openlibrary.openlibrary.availablebooks.service.AvailableBooksService;
import com.openlibrary.openlibrary.mybooks.DTO.BookDTO;
import com.openlibrary.openlibrary.mybooks.DTO.CreateBookDto;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/books/availablebooks")
public class AvailableBooksController {

    @Autowired
    AvailableBooksService service;
    
    @GetMapping("/myAvailableBooks/{userId}")
    public ResponseEntity<List<BookDTO>> getAllMyAvailableBook(@PathVariable Long userId) {
        return new ResponseEntity<List<BookDTO>>(service.findAllMyAvailableBooks(userId), HttpStatus.OK);
    }
   
    @GetMapping("/{userId}")
    public ResponseEntity<List<BookDTO>> getAllAvailableBooks(@PathVariable Long userId){
        return new ResponseEntity<List<BookDTO>>(service.findAllBooks(userId),HttpStatus.OK);
        }
    @GetMapping("/myAvailableBooks/{userId}/{id}")
    public ResponseEntity<BookDTO> getMyAvailableBookById(@PathVariable Long userId,@PathVariable Long id) throws Exception{
    return new ResponseEntity<BookDTO>(service.findBookById(userId, id), HttpStatus.OK);
}

    @GetMapping("/{userId}/{id}")
        public ResponseEntity<BookDTO> getBookById(@PathVariable Long userId,@PathVariable Long id) throws Exception{
        return new ResponseEntity<BookDTO>(service.findBookById(userId, id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<AvailableBooksEntity> createNewBook(@RequestBody CreateBookDto createBookDto){
        return new ResponseEntity<AvailableBooksEntity>(service.createBook(createBookDto),HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AvailableBooksEntity> editBook(@RequestBody AvailableBooksEntity entity, @PathVariable long id) throws Exception{
        return new ResponseEntity<AvailableBooksEntity>(service.updateBook(entity, id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteAvailableBooksById(@PathVariable long id) {
   service.deleteBookById(id);
   return HttpStatus.NO_CONTENT;
     
    }
}
