package com.openlibrary.openlibrary.availablebooks.DTO;

public class BookDTO {
    private long id;
    private String imageUrl;
    private String bookName;
    private String bookType;
    private String author;
    private long userId;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getBookType() {
        return bookType;
    }
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public BookDTO(long id, String imageUrl, String bookName, String bookType, String author, long userId) {
        super();
        this.id = id;
        this.imageUrl = imageUrl;
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.userId = userId;
    }
    
    
    
}


