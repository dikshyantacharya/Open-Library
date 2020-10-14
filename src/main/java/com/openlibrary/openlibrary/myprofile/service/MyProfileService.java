package com.openlibrary.openlibrary.myprofile.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;
import com.openlibrary.openlibrary.myprofile.repository.MyProfileRepository;

@Service
public class MyProfileService {

    @Autowired
    MyProfileRepository repository;
    
    public List<MyProfileEntity> findAllProfiles(){
        return repository.findAll();
    }
    
    public MyProfileEntity findMyProfileById(long id) throws Exception {
        Optional<MyProfileEntity> entity = repository.findById(id);
        if(entity.isPresent()) {
            return entity.get();
        }
        else {
            throw new Exception();
        }
    }
    
    public MyProfileEntity createMyProfile(MyProfileEntity entity) {
        repository.save(entity);
        return entity;
    }
    public MyProfileEntity updateMyProfile(MyProfileEntity entity, long id) throws Exception {
        Optional<MyProfileEntity> toUpdateEntity = repository.findById(id);
        if(toUpdateEntity.isPresent()) {
            toUpdateEntity.get().setAddress(entity.getAddress());
            toUpdateEntity.get().setFirstName(entity.getFirstName());
            toUpdateEntity.get().setLastName(entity.getLastName());
            toUpdateEntity.get().setEmailId(entity.getEmailId());
            repository.save(toUpdateEntity.get());
            return toUpdateEntity.get();
        }
        else {
            throw new Exception();
        }
    }
    
    public void deleteMyProfileById(long id) {
       Optional<MyProfileEntity> toDeleteEntity= repository.findById(id); 
       if(toDeleteEntity.isPresent()) {
           repository.deleteById(id);
       }
    }
}
