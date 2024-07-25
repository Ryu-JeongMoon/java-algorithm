package algorithm.leetcode.easy;

/**
 * Palindrome Number
 */
public class _9 {

  public static void main(String[] args) {
    _9 instance = new _9();

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
    String number = String.valueOf(x);
    int length = number.length();
    for (int i = 0; i < length; i++) {
      if (number.charAt(i) != number.charAt(length - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}

/*
time complexity
O(x.length)

critical point

reference
https://leetcode.com/problems/palindrome-number/
*/
