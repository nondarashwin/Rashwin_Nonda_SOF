import java.util.Scanner;

public class SPECIAL_SEQUENCE {
    public static void main(String[] args) {
        int terms[] = {2, 1, 3}, n, term, i = 0, sequence_add;
        sequence_add = terms.length;
        Scanner sc = new Scanner(System.in);
        //System.out.println(terms.length);
        n = sc.nextInt();

        while (i < terms.length) {
            if (terms[i] <= n) {

                if (i != 0) {
                    System.out.print(' ');
                }
                System.out.print(terms[i]);
                i++;
            } else
                break;
        }
        while (1 != 0) {
            i = terms.length - 1;
            term = 0;
            while (i >= terms.length - sequence_add) {
                term += terms[i];
                i--;
            }
            if (term <= n) {
                System.out.print(' ');
                System.out.print(term);
                int j = 0;
                while (j < terms.length - 1) {
                    terms[j] = terms[j + 1];
                    j++;
                }
                terms[j] = term;
            } else
                break;
        }
        sc.close();
    }
}
