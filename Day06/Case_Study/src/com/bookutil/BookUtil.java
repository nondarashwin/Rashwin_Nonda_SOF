package com.bookutil;

import com.book.*;

import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) throws InvalidInputException {
        int choice;
        BookStore bookStore = new BookStore();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice\n1.Add Books\n2.Display All books\n3.Search by author\n4.Search by title");
        System.out.println("5.search by book id\n6.update books\n7.exit");
        choice = sc.nextInt();
        String junk = sc.nextLine();
        while (choice < 7) {
            switch (choice) {
                case 1:
                    Book b;
                    System.out.println("Enter title of the book");
                    String title = sc.nextLine();
                    System.out.println("Enter Author of the book");
                    String author = sc.nextLine();
                    System.out.println("Enter Category of the book");
                    String category = sc.nextLine();
                    System.out.println("Enter the price");
                    float price = sc.nextFloat();
                    junk = sc.nextLine();
                    b = new Book(title, author, category, price);
                    if (b.error_bit) {
                        break;
                    }
                    bookStore.addBook(b);
                    break;
                case 2:
                    bookStore.displayAll();
                    break;
                case 3:
                    System.out.println("Enter Author of the search");
                    String author_search = sc.nextLine();
                    bookStore.searchByAuthor(author_search);
                    break;
                case 4:
                    System.out.println("Enter title to  search");
                    String title_search = sc.nextLine();
                    bookStore.searchByTitle(title_search);
                    break;
                case 5:
                    System.out.println("Enter id to  search");
                    String id_search = sc.nextLine();
                    bookStore.displayBook(id_search);
                    break;
                case 6:
                    System.out.println("Enter id to  update");
                    String id_update = sc.nextLine();
                    bookStore.updateBook(id_update);
                    break;

            }
            System.out.println("choices\n 1.Add Books \n2.Display All books \n3.Search by author \n 4.Search by title");
            System.out.println("5.search by book id \n 6.update books \n 7.exit");
            choice = sc.nextInt();
            junk = sc.nextLine();
        }

    }
}
