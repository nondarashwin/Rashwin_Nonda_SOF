package com.book;

import java.util.Scanner;

public class BookStore {
    Book[] books;

    public void addBook(Book b) {
        int len;
        Book[] temp;
        if (books == null) {
            len = 1;
            temp = new Book[len];
            temp[len - 1] = b;
        } else {
            len = books.length + 1;
            temp = new Book[len];
            for (int i = 0; i < books.length; i++) {
                temp[i] = books[i];
            }
            temp[len - 1] = b;
        }

        books = temp;
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
        if (books == null) {
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
        if (books == null) {
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

    public void updateBook(String bookId) {
        boolean flag = false;
        int i;
        if (books == null) {
            System.out.println("no books found");
            return;
        }
        for (i = 0; i < books.length; i++) {
            if (books[i].getBookId().equals(bookId)) {
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
                String junk=sc.nextLine();
                switch (choice) {
                    case 1:
                        String author;
                        author = sc.nextLine();
                        books[i].setAuthor(author);
                        break;
                    case 2:
                        String title;
                        title = sc.nextLine();
                        books[i].setTitle(title);
                        break;
                    case 3:
                        float price;
                        price = sc.nextFloat();
                        if (!books[i].setPrice(price))
                            System.out.println("Price cannot be negative");
                        break;
                    case 4:
                        String category;
                        category = sc.nextLine();
                        if (!books[i].setCategory(category))
                            System.out.println("Category Not found");
                        break;
                    default:
                        flag = false;
                }


            }
        }

    }

    public void displayBook(String bookId) {
        boolean flag = false;
        if (books == null) {
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
        if (books == null) {
            System.out.println("no books found");
        } else {
            for (Book book : books) {
                this.displayBook(book);
            }
        }
    }
}
