package algorithm.leetcode.medium;

/**
 * Pow(x, n)
 */
public class _50_2 {

  public static void main(String[] args) {
    _50_2 instance = new _50_2();

    System.out.println(instance.myPow(2.00000, 10));
    System.out.println(instance.myPow(2.10000, 3));
    System.out.println(instance.myPow(2.00000, -2));
    System.out.println(instance.myPow(0.99999, 95000000));
    System.out.println(instance.myPow(1, 9500000));
    System.out.println(instance.myPow(-1, -2147483648));
  }

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    double squareRoot = myPow(x, n / 2);
    double square = squareRoot * squareRoot;
    if (n % 2 == 0) {
      return square;
    } else if (n > 0) {
      return square * x;
    } else {
      return square / x;
    }
  }
}

/*
time complexity
O(logN)

critical point
recursive way

매번 x를 제곱하지 않고 2씩 나누어 계산한 값을 기반으로 현재 값인 square를 만들어냄
O(n)이 아닌 O(logN)으로 계산 가능

reference
https://leetcode.com/problems/powx-n/
*/
