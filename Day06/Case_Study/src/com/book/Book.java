package com.book;

import javax.management.openmbean.InvalidKeyException;

public class Book {
    private String bookId, title, author, category;
    private final String[] categories = {"Science", "Fiction", "Technology", "Others"};
    private float price;
    public boolean error_bit = false;
    private static int id = 1;
    private final int digit = 3;

    public Book(String title, String author, String category, float price) throws InvalidInputException {
        setBookId();
        setTitle(title);
        setAuthor(author);
        setCategory(category);
        setPrice(price);
        System.out.println("*******");
        System.out.println("The book is added with these details");
        System.out.println("Id:" + getBookId());
        System.out.println("Title:" + getTitle());
        System.out.println("Author:" + getAuthor());
        System.out.println("Category:" + getCategory());
        System.out.println("Price:" + getPrice());
    }

    public String getBookId() {
        return bookId;
    }

    private String generateId() throws InvalidInputException {
        int temp = id++, count = 0;
        //System.out.println(id);
        String output = "B";
        if (temp == 0) {
            return "B001";
        }
        int temp1 = temp;
        while (temp != 0) {
            count += 1;
            temp /= 10;
        }
        if (count > this.digit) {
            System.out.println("Book store is full");
            throw new InvalidInputException("The Book Store is full");
        }
        int add_zero = this.digit - count;
        while (add_zero != 0) {
            String s_temp = output;
            output = s_temp + 0;
            add_zero--;
            //System.out.println(output);
        }
        return output + temp1;
    }

    public void setBookId() throws InvalidInputException {

        String temp = generateId();
        if (!temp.equals("ERROR")) {
            this.bookId = temp;

        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {

        return category;
    }

    public void setCategory(String category) throws InvalidInputException {
        boolean flag = false;
        for (String type : categories) {
            if (category.toLowerCase().equals(type.toLowerCase())) {
                category = type;
                flag = true;
            }
        }
        if (flag) {
            this.category = category;

        }else
            throw new InvalidInputException("The Category Not found");


    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) throws InvalidInputException {
        if (price > 0) {
            this.price = price;

        }
        else
            throw new InvalidInputException("Price Cant be negative");

    }
}
