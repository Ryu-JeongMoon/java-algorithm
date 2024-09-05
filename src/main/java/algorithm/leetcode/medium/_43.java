package algorithm.leetcode.medium;

import java.math.BigInteger;

/**
 * Multiply Strings
 */
public class _43 {

  public static void main(String[] args) {
    _43 instance = new _43();

    System.out.println(instance.multiply("2", "3"));
    System.out.println(instance.multiply("123", "456"));
  }

  public String multiply(String num1, String num2) {
    return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
  }
}

/*
time complexity
O(N) or O(NlogN)

critical point
BigInteger, The range must be at least 1 to 2^500000000

reference
https://leetcode.com/problems/multiply-strings/
*/
