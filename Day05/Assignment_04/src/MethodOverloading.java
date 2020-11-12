public class MethodOverloading {
    double avg(int a, int b) {
        return (double) (a + b) / 2;
    }

    double avg(double a, double b) {
        return (a + b) / 2;
    }

    double avg(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static void main(String[] args) {
        MethodOverloading MO = new MethodOverloading();
        System.out.println(MO.avg(1, 2));
        System.out.println(MO.avg(2.0, 5.0));
        System.out.println(MO.avg(1, 2, 3));
    }
}
