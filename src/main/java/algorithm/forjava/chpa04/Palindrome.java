package algorithm.forjava.chpa04;

import java.util.Stack;

/**
 * 문제 8
 */
public class Palindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("ababaXababa"));
    System.out.println(isPalindromeByStack("cdaababaXababaadc"));
  }

  static boolean isPalindrome(String input) {
    char[] chars = input.toCharArray();
    int i = 0, j = chars.length - 1;

    while (i < j && chars[i++] == chars[j--]) {
      System.out.printf("working %d %d\n", i, j);
    }

    if (i < j) {
      System.out.println("Not a Palindrome");
      return false;
    } else {
      System.out.println("Palindrome");
      return true;
    }
  }

  static boolean isPalindromeByStack(String input) {
    char[] chars = input.toCharArray();
    int i = 0, j = (chars.length - 1) / 2;
    Stack<Character> stack = new Stack<>();

    while (chars[i] != 'X') {
      stack.push(chars[i++]);
    }

    while (chars[j] != 'X') {
      if (stack.pop() != chars[j++]) {
        return false;
      }
    }

    return true;
  }
}
