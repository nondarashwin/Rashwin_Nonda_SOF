public class ExcpetionTest {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(a / b);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No inputs provided");
        } catch (ArithmeticException e) {
            System.out.println("division with zero is not possible");
        } catch (NumberFormatException e) {
            System.out.println("Only Integers are allowed");
        }
    }
}
