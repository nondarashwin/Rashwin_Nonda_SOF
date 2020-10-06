package com.book;

public class Book {
    private String bookId, title, author, category;
    private final String[] categories = {"Science", "Fiction", "Technology", "Others"};
    private float price;
    public boolean error_bit = false;
    private static int id = 1;
    private final int digit = 3;

    public Book(String title, String author, String category, float price) {
        if (setBookId()) {
            setTitle(title);
            setAuthor(author);
            if (setCategory(category)) {
                if (setPrice(price)) {
                    System.out.println("*******");
                    System.out.println("The book is added with these details");
                    System.out.println("Id:" + getBookId());
                    System.out.println("Title:" + getTitle());
                    System.out.println("Author:" + getAuthor());
                    System.out.println("Category:" + getCategory());
                    System.out.println("Price:" + getPrice());
                } else {
                    System.out.println("Price cannot be Negative");
                    error_bit = true;
                }
            } else {
                System.out.println("Category Not found");
                error_bit = true;
            }
        }

    }

    public String getBookId() {
        return bookId;
    }

    private String generateId() {
        int temp =id++, count = 0;
        //System.out.println(id);
        String output = "B";
        if (temp == 0) {
            return "B001";
        }
        int temp1=temp;
        while (temp != 0) {
            count += 1;
            temp /= 10;
        }
        if (count > this.digit) {
            System.out.println("Book store is full");
            return "ERROR";
        }
        int add_zero = this.digit - count;
        while (add_zero != 0) {
            String s_temp = output;
            output = s_temp + 0;
            add_zero--;
            //System.out.println(output);
        }
        return output +temp1 ;
    }

    public boolean setBookId() {

        String temp = generateId();
        if (!temp.equals("ERROR")) {
            this.bookId = temp;
            return true;
        }
        return false;
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

    public boolean setCategory(String category) {
        boolean flag = false;
        for (String type : categories) {
            if (category.toLowerCase().equals(type.toLowerCase())) {
                category = type;
                flag = true;
            }
        }
        if (flag) {
            this.category = category;

        }
        return flag;

    }

    public float getPrice() {
        return price;
    }

    public boolean setPrice(float price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }
}
