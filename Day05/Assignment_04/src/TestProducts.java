class Products {
    private String productCode, productName;
    private double productPrice;
    private char categoryCode;
    private static int counter = 100;

    public String generateCode() {
        String code;
        code = "" + this.categoryCode + (++Products.counter);
        return code;
    }

    public void getProductDetails() {
        System.out.println("Product: Code " + productCode + ", Name " + productName + ",Price " + productPrice + ",Category " + categoryCode);
    }

    public Products() {
        this.productPrice = 0.0;
        this.productName = "No name";
        this.productCode = generateCode();
        this.categoryCode = 'E';
    }

    public Products(String productName, char categoryCode, double productPrice) {
        this.productCode = generateCode();
        this.productPrice = productPrice;
        this.categoryCode = categoryCode;
        this.productName = productName;
    }

    public Products(String productName, double productPrice) {
        this.productCode = generateCode();
        this.productName = productName;
        this.categoryCode = 'E';
        this.productPrice = productPrice;
    }

    public char getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(char categoryCode) {
        this.categoryCode = categoryCode;
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

    public void displayValues() {
        System.out.println("Product Code : " + productCode);
        System.out.println("Product Name : " + productName);
        System.out.println("Product Price : " + productPrice);
    }

}

public class TestProducts {
    public static void main(String[] args) {
        //Products pq=new Products();
        Products pq1 = new Products("Laptop", 'E', 45000.00);
        pq1.getProductDetails();
        Products pq2 = new Products("Laptop", 45000.00);
        pq2.getProductDetails();
        Products pq3 = new Products("Dell", 2356.0);
        pq3.getProductDetails();
    }
}
