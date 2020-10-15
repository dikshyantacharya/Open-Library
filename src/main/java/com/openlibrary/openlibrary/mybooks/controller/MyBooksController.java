package com.openlibrary.openlibrary.mybooks.controller;

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

import com.openlibrary.openlibrary.mybooks.DTO.BookDTO;
import com.openlibrary.openlibrary.mybooks.DTO.CreateBookDto;

import com.openlibrary.openlibrary.mybooks.entity.MyBooksEntity;
import com.openlibrary.openlibrary.mybooks.service.MyBooksService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/books/myBooks")
public class MyBooksController {

    @Autowired
    MyBooksService service;

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookDTO>> getAllMyBooks(@PathVariable Long userId) {
        return new ResponseEntity<List<BookDTO>>(service.findAllMyBooks(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{id}")
    public ResponseEntity<BookDTO> getMyBookById(@PathVariable Long userId ,@PathVariable Long id) throws Exception {
        return new ResponseEntity<BookDTO>(service.findMyBooksById(userId, id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<MyBooksEntity> createMyBook(@RequestBody CreateBookDto createBookDto) {
        return new ResponseEntity<MyBooksEntity>(service.createMyBooks(createBookDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyBooksEntity> updateMyBook(@PathVariable long id, @RequestBody MyBooksEntity entity)
            throws Exception {
        return new ResponseEntity<MyBooksEntity>(service.updateMyBooks(entity, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteMyBooksById(@PathVariable long id) {
      service.deleteBookById(id);
      return HttpStatus.NO_CONTENT;
    }
}
