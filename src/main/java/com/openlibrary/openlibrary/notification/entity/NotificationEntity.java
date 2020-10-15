package com.openlibrary.openlibrary.notification.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openlibrary.openlibrary.availablebooks.entity.AvailableBooksEntity;
import com.openlibrary.openlibrary.myprofile.entity.MyProfileEntity;

@Entity
@Table
public class NotificationEntity {
    @Id
    @GeneratedValue
    private long id;
    private String notification;
    
    
    @ManyToOne
    @JoinColumn(name = "receiver_profile_fk", referencedColumnName = "id")
    @JsonIgnore
    private MyProfileEntity myProfileEntity;
    
    @ManyToOne
    @JoinColumn(name = "sender_profile_fk", referencedColumnName = "id")
    @JsonIgnore
    private MyProfileEntity senderProfileEntity;
    
    @ManyToOne
    @JoinColumn(name = "book_fk", referencedColumnName = "id")
    @JsonIgnore
    private AvailableBooksEntity availableBooksEntity;


public MyProfileEntity getMyProfileEntity() {
        return myProfileEntity;
    }

    public void setMyProfileEntity(MyProfileEntity myProfileEntity) {
        this.myProfileEntity = myProfileEntity;
    }

public String getNotification() {
    return notification;
}

public void setNotification(String notification) {
    this.notification = notification;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public MyProfileEntity getSenderProfileEntity() {
    return senderProfileEntity;
}

public void setSenderProfileEntity(MyProfileEntity senderProfileEntity) {
    this.senderProfileEntity = senderProfileEntity;
}

public AvailableBooksEntity getAvailableBooksEntity() {
    return availableBooksEntity;
}

public void setAvailableBooksEntity(AvailableBooksEntity availableBooksEntity) {
    this.availableBooksEntity = availableBooksEntity;
}
}