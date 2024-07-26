package algorithm.leetcode.easy;

/**
 * Palindrome Number
 */
public class _9_2 {

  public static void main(String[] args) {
    _9_2 instance = new _9_2();

    System.out.println(instance.isPalindrome(121));
    System.out.println(instance.isPalindrome(-121));
    System.out.println(instance.isPalindrome(10));
    System.out.println(instance.isPalindrome(11));
    System.out.println(instance.isPalindrome(13));
    System.out.println(instance.isPalindrome(131));
    System.out.println(instance.isPalindrome(1315));
    System.out.println(instance.isPalindrome(1315131));
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int digitPlace = -1, copied = x;
    while (copied != 0) {
      copied /= 10;
      ++digitPlace;
    }

    int leftDelimiter = (int) Math.pow(10, digitPlace), rightDelimiter = 10;
    while (leftDelimiter >= rightDelimiter) {
      int leftMost = x / leftDelimiter;
      int rightMost = x % rightDelimiter;
      if (leftMost != rightMost) {
        return false;
      }
      x = (x % leftDelimiter) / rightDelimiter;
      leftDelimiter /= 100;
    }
    return true;
  }
}

/*
time complexity
O(x.length)

critical point
5ms, Beats 71.53%

reference
https://leetcode.com/problems/palindrome-number/
*/
