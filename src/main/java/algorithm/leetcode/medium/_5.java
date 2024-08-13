package algorithm.leetcode.medium;

/**
 * Longest Palindromic Substring
 */
public class _5 {

  public static void main(String[] args) {
    _5 instance = new _5();

    System.out.println(instance.longestPalindrome("babad"));
    System.out.println(instance.longestPalindrome("cbbd"));
  }

  public String longestPalindrome(String s) {
    String max = "", expanded;
    int length = s.length();
    for (int i = 0; i < length; i++) {
      expanded = expand(i, i, s);
      if (max.length() < expanded.length()) {
        max = expanded;
      }

      expanded = expand(i, i + 1, s);
      if (max.length() < expanded.length()) {
        max = expanded;
      }
    }
    return max;
  }

  private String expand(int left, int right, String s) {
    while (0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
      --left;
      ++right;
    }
    return s.substring(left + 1, right);
  }
}

/*
time complexity
O(N^2)

critical point
짝수 팰린드롬도 고려

reference
https://leetcode.com/problems/longest-palindromic-substring/
*/
