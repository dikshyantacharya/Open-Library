package com.openlibrary.openlibrary.myprofile.controller;

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

import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;
import com.openlibrary.openlibrary.myprofile.service.MyProfileService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/api/profile")
public class MyProfileController {
    
    @Autowired
    MyProfileService service;

    @GetMapping
    public ResponseEntity<List<MyProfileEntity>> getAllProfile(){
        return new ResponseEntity<List<MyProfileEntity>>(service.findAllProfiles(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MyProfileEntity> getMyProfileById(@PathVariable long id) throws Exception{
        return new ResponseEntity<MyProfileEntity>(service.findMyProfileById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<MyProfileEntity> createMyProfile(@RequestBody MyProfileEntity entity){
        return new ResponseEntity<MyProfileEntity>(service.createMyProfile(entity), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MyProfileEntity> updateMyProfile(@RequestBody MyProfileEntity entity, @PathVariable long id) throws Exception{
        return new ResponseEntity<MyProfileEntity>(service.updateMyProfile(entity, id), HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public HttpStatus deleteMyProfile(@PathVariable long id) {
        service.deleteMyProfileById(id);
        return HttpStatus.NO_CONTENT;
    }
}