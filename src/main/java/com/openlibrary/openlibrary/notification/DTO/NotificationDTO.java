package com.openlibrary.openlibrary.notification.DTO;

public class NotificationDTO {
private long id;
private String notification;
private long userId;
public long senderId;
public long availableBooksId;

public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
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
public NotificationDTO(long id, String notification, long userId, long senderId, long availableBooksId) {
    super();
    this.id = id;
    this.notification = notification;
    this.userId = userId;
    this.senderId = senderId;
    this.availableBooksId = availableBooksId;
}


}
