package com.openlibrary.openlibrary.notification.DTO;

public class CreateNotificationDTO {
    
    private String notification;
    private long userId;
    public long senderId;
    public long availableBooksId;
    
    
   
    
    public long getSenderId() {
        return senderId;
    }
    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }
    public long getAvailableBooksId() {
        return availableBooksId;
    }
    public void setAvailableBooksId(long availableBooksId) {
        this.availableBooksId = availableBooksId;
    }
    public String getNotification() {
        return notification;
    }
    public void setNotification(String notification) {
        this.notification = notification;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public CreateNotificationDTO(long id, String notification, long userId) {
        super();
       
        this.notification = notification;
        this.userId = userId;
    }

    }


