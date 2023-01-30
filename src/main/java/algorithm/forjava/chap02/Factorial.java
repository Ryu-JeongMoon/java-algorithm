package algorithm.forjava.chap02;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(facto(5));

        System.out.println(printFacto(5));
    }

    static int facto(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * facto(n - 1);
        }
    }

    static int printFacto(int n) {
        if (n == 1) {
            System.out.println("n = " + n);
            return 1;
        } else {
            System.out.println("n = " + n);
            return n * printFacto(n - 1);
        }
    }
}
