class Product{
    private String productCode,productName;
    private double productPrice;
    public Product(){
        this.productPrice=0.0;
        this.productName="No name";
        this.productCode="No code";
    }
    public Product(String productCode,String productName,double productPrice){
        this.productCode=productCode;
        this.productName=productName;
        this.productPrice=productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void displayValues(){
        System.out.println("Product Code : "+productCode);
        System.out.println("Product Name : "+productName);
        System.out.println("Product Price : "+productPrice);
    }

}
public class TestProduct {
    public static void main(String[] args){
        System.out.println("Question 1");
        Product p=new Product();
        p.displayValues();
        Product pq=new Product("1101","Laptop",45000);
        pq.displayValues();
        System.out.println("Question 2");
        Product p1=new Product();
        p1.setProductCode("P1101");
        p1.setProductName("Laptop");
        p1.setProductPrice(45000);
        System.out.println("Product Code : "+p1.getProductCode());
        System.out.println("Product Name : "+p1.getProductName());
        System.out.println("Product Price : "+p1.getProductPrice());

    }
}
