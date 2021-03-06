package com.example.entity;

import com.aerospike.client.Record;
import com.example.entity.aerodb.BookEntity;

public class Book {
    private final int isbn;
    private final String title;
    private final String author;
    private final int noOfPages;
    private final double price;

    public Book(int isbn, String title, String author, int noOfPages, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
        this.price = price;
    }

    public static Book getBook(Record record) {
        if (record == null) {
            return null;
        }
        String title = record.getString("title");
        String author = record.getString("author");
        Long isbn = record.getLong("isbn");
        Long noOfPages = record.getLong("noOfPages");
        Long price = record.getLong("price");
        return new Book(isbn.intValue(), title, author, noOfPages.intValue(), price);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public double getPrice() {
        return price;
    }

    public int getIsbn() {
        return isbn;
    }

}
