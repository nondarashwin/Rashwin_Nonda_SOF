public class ExcpetionTest {
    public static void main(String[] args){
        try{
            int a=Integer.parseInt(args[0]);
            int b=Integer.parseInt(args[1]);
            System.out.println(a/b);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Arguments length is zero");
        }catch (ArithmeticException e){
            System.out.println("number cannot be divided by zero");
        }
    }
}
