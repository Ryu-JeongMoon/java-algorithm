package algorithm.forjava.chpa04;

import java.util.Stack;

/**
 * 문제 8
 */
public class PalindromeUtils {

  public static void main(String[] args) {
    System.out.println(isPalindrome("ababaXababa"));
    System.out.println(isPalindromeByStack("cdaababaXababaadc"));
  }

  public static boolean isPalindrome(String input) {
    int start = 0, end = input.length() - 1;
    while (start <= end) {
      if (input.charAt(start++) != input.charAt(end--)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindromeByStack(String input) {
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
