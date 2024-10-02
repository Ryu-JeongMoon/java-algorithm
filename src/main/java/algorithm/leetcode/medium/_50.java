package algorithm.leetcode.medium;

/**
 * Pow(x, n)
 */
public class _50 {

  public static void main(String[] args) {
    _50 instance = new _50();

    System.out.println(instance.myPow(2.00000, 10));
    System.out.println(instance.myPow(2.10000, 3));
    System.out.println(instance.myPow(2.00000, -2));
    System.out.println(instance.myPow(0.99999, 95000000));
    System.out.println(instance.myPow(1, 9500000));
    System.out.println(instance.myPow(-1, -2147483648));
  }

  public double myPow(double x, int n) {
    if (x == 1) {
      return x;
    } else if (x == -1) {
      return n % 2 != 0 ? x : -x;
    }

    double prev, next;
    if (n > 0) {
      prev = 0;
      next = x;
      while (prev != next && --n > 0) {
        prev = next;
        next *= x;
      }
    } else {
      prev = 0;
      next = 1;
      while (prev != next && ++n <= 0) {
        prev = next;
        next = next * 1 / x;
      }
    }
    return next;
  }
}

/*
time complexity
O(N)

critical point
시간 제한이 있으므로 회귀되는 케이스 제외 처리

reference
https://leetcode.com/problems/powx-n/
*/
