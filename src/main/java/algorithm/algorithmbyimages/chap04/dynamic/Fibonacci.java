package algorithm.algorithmbyimages.chap04.dynamic;

public class Fibonacci {

    private static long[] d = new long[100];

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(fibonacci(20));
        long endTime = System.nanoTime();
        System.out.println("time = " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        System.out.println(fibonacciDP(99));
        endTime = System.nanoTime();
        System.out.println("time = " + (endTime - startTime) + "ns");
    }

    private static int fibonacci(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    private static long fibonacciDP(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        if (d[x] != 0) {
            return d[x];
        }

        d[x] = fibonacciDP(x - 1) + fibonacciDP(x - 2);
        return d[x];
    }
}
