package com.openlibrary.openlibrary.mybooks.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openlibrary.openlibrary.common.BaseEntity;
import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;

@Entity
@Table
public class MyBooksEntity extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "profile_fk", referencedColumnName = "id")
    @JsonIgnore
    private MyProfileEntity myProfileEntity;

    public MyProfileEntity getMyProfileEntity() {
        return myProfileEntity;
    }

    public void setMyProfileEntity(MyProfileEntity myProfileEntity) {
        this.myProfileEntity = myProfileEntity;
    }

    @Override
    public long getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }



    @Override
    public void setId(long id) {
        // TODO Auto-generated method stub
        super.setId(id);
    }

    @Override
    public String getImageUrl() {
        // TODO Auto-generated method stub
        return super.getImageUrl();
    }

    @Override
    public void setImageUrl(String imageUrl) {
        // TODO Auto-generated method stub
        super.setImageUrl(imageUrl);
    }

    @Override
    public String getBookName() {
        // TODO Auto-generated method stub
        return super.getBookName();
    }

    @Override
    public void setBookName(String bookName) {
        // TODO Auto-generated method stub
        super.setBookName(bookName);
    }

    @Override
    public String getBookType() {
        // TODO Auto-generated method stub
        return super.getBookType();
    }

    @Override
    public void setBookType(String bookType) {
        // TODO Auto-generated method stub
        super.setBookType(bookType);
    }

    @Override
    public String getAuthor() {
        // TODO Auto-generated method stub
        return super.getAuthor();
    }

    @Override
    public void setAuthor(String author) {
        // TODO Auto-generated method stub
        super.setAuthor(author);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

   
 

    
}
