package algorithm.leetcode.hard;

import java.util.regex.Pattern;

/**
 * Regular Expression Matching
 */
public class _10 {

  public static void main(String[] args) {
    _10 instance = new _10();

    System.out.println(instance.isMatch("aa", "a"));
    System.out.println(instance.isMatch("aa", "a*"));
    System.out.println(instance.isMatch("ab", ".*"));
    System.out.println(instance.isMatch("abc", "a***abc"));
  }

  public boolean isMatch(String s, String p) {
    StringBuilder sb = new StringBuilder(p);
    while (sb.indexOf("**") != -1) {
      sb.replace(sb.indexOf("**"), sb.indexOf("**") + 2, "*");
    }
    Pattern pattern = Pattern.compile(sb.toString());
    return pattern.matcher(s).matches();
  }
}

/*
time complexity
O(N)

critical point
445 ms, Beats 17.56%

reference
https://leetcode.com/problems/regular-expression-matching/
*/
