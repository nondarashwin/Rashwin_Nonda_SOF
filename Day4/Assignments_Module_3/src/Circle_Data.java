import java.util.Scanner;

public class Circle_Data {
    public static void main(String[] args) {
        float radius;
        String option = new String();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Radius");
        radius = sc.nextFloat();
        System.out.println("The Output Required");
        option = sc.next();
        switch (option) {
            case "DIA":
                System.out.format("The Diameter of Circle is %.2f", (2 * radius));
                break;
            case "AR":
                System.out.format("The Area of Circle is %.2f", (Math.PI * radius * radius));
                break;
            case "PER":
                System.out.format("The Perimeter of circle %.2f", (2 * Math.PI * radius));
                break;
            case "ARSEM":
                System.out.format("The Area of Semi Circle %.2f", (Math.PI * radius * radius) / 2);
                break;
            default:
                System.out.println("Please Select Right option");
                break;
        }
        sc.close();
    }
}
