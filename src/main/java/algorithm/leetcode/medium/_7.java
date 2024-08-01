package algorithm.leetcode.medium;

/**
 * Reverse Integer
 */
public class _7 {

  public static void main(String[] args) {
    _7 instance = new _7();

    System.out.println(instance.reverse(123));
    System.out.println(instance.reverse(-123));
    System.out.println(instance.reverse(120));
  }

  public int reverse(int x) {
    long result = 0;
    while (x != 0) {
      result = result * 10 + x % 10;
      x /= 10;
    }
    return Math.abs(result) > Integer.MAX_VALUE ? 0 : (int) result;
  }
}

/*
time complexity
O(log10(n)) = O(log(n))

critical point

reference
https://leetcode.com/problems/reverse-integer/
*/
