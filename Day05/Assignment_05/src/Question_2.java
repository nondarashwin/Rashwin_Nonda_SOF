import java.util.Scanner;

class book {
    private int bookNo;
    private String title;
    private String author;
    private float price;

    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

class Engineeringbooks extends book {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

public class Question_2 {
    public static void main(String[] args) {
        Engineeringbooks ee = new Engineeringbooks();
        Scanner sc = new Scanner(System.in);
        System.out.println("Book no");
        ee.setBookNo(sc.nextInt());
        System.out.println("Book name");
        ee.setTitle(sc.nextLine());
        System.out.println("Book Author");
        ee.setAuthor(sc.nextLine());
        System.out.println("Book Price");
        ee.setPrice(sc.nextFloat());
        System.out.println("Book Category");
        ee.setCategory(sc.nextLine());
        System.out.println("Book no" + ee.getBookNo());
        System.out.println("Book name" + ee.getTitle());
        System.out.println("Book Author" + ee.getAuthor());
        System.out.println("Book Price" + ee.getPrice());

    }
}
