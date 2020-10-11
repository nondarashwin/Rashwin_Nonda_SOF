package com1.book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    ArrayList<Book> books=new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    private void displayBook(Book b) {
        System.out.println("******");
        System.out.println("Book ID:" + b.getBookId());
        System.out.println("Book Title:" + b.getTitle());
        System.out.println("Book Author" + b.getAuthor());
        System.out.println("Book Category" + b.getCategory());
        System.out.println("Book Price" + b.getPrice());
    }

    public void searchByTitle(String title) {
        boolean flag = false;
        if (books == null ||books.size()==0) {
            System.out.println("no books found");
            return;
        }
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                flag = true;
                displayBook(book);
            }
        }
        if (!flag)
            System.out.println("the Book title:" + title + " not found");
    }

    public void searchByAuthor(String author) {
        boolean flag = false;
        if (books == null ||books.size()==0) {
            System.out.println("no books found");
            return;
        }
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                flag = true;
                displayBook(book);
            }
        }
        if (!flag)
            System.out.println("the Book Author:" + author + " not found");
    }

    public void updateBook(String bookId) throws InvalidInputException {
        boolean flag = false;
        int i;
        if (books == null ||books.size()==0) {
            System.out.println("no books found");
            return;
        }
        for (i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(bookId)) {
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println("the Book Id:" + bookId + " not found");
        else {
            while (flag) {
                System.out.println("choose which to update \n 1.Author \n2.Title \n3.Price \n 4.Category \n 5.exit");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                String junk = sc.nextLine();
                switch (choice) {
                    case 1:
                        String author;
                        author = sc.nextLine();
                        books.get(i).setAuthor(author);
                        break;
                    case 2:
                        String title;
                        title = sc.nextLine();
                        books.get(i).setTitle(title);
                        break;
                    case 3:
                        float price;
                        price = sc.nextFloat();
                        books.get(i).setPrice(price);
                        break;
                    case 4:
                        String category;
                        category = sc.nextLine();
                        books.get(i).setCategory(category);
                        break;
                    default:
                        flag = false;
                }


            }
        }

    }

    public void displayBook(String bookId) {
        boolean flag = false;
        if (books == null ||books.size()==0) {
            System.out.println("no books found");
            return;
        }
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                flag = true;
                displayBook(book);
            }
        }
        if (!flag)
            System.out.println("the Book Id:" + bookId + " not found");
    }

    public void displayAll() {
        if (books == null ||books.size()==0){
            System.out.println("no books found");
        } else {
            for (Book book : books) {
                this.displayBook(book);
            }
        }
    }
}
