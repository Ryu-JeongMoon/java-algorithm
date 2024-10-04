package algorithm.leetcode.medium;

/**
 * Pow(x, n)
 */
public class _50_3 {

  public static void main(String[] args) {
    _50_3 instance = new _50_3();

    System.out.println(instance.myPow(2.00000, 10));
    System.out.println(instance.myPow(2.10000, 3));
    System.out.println(instance.myPow(2.00000, -2));
    System.out.println(instance.myPow(0.99999, 95000000));
    System.out.println(instance.myPow(1, 9500000));
    System.out.println(instance.myPow(-1, -2147483648));
  }

  public double myPow(double x, int n) {
    int exponent = n;
    if (exponent < 0) {
      x = 1 / x;
      exponent = -exponent;
    }

    double result = 1.0;
    double currentProduct = x;

    while (exponent > 0) {
      if ((exponent % 2) == 1) {
        result *= currentProduct;
      }
      currentProduct *= currentProduct;
      exponent /= 2;
    }

    return result;
  }
}

/*
time complexity
O(logN)

critical point
iterative way

reference
https://leetcode.com/problems/powx-n/
*/
