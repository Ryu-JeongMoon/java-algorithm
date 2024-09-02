package algorithm.leetcode.easy;

/**
 * Valid Anagram
 */
public class _242 {

  public static void main(String[] args) {
    _242 instance = new _242();

    System.out.println(instance.isAnagram("anagram", "nagaram"));
    System.out.println(instance.isAnagram("rat", "car"));
  }

  public boolean isAnagram(String s, String t) {
    int length = s.length();
    if (length != t.length()) {
      return false;
    }

    int[][] charCounts = new int[2][26];
    for (int i = 0; i < length; i++) {
      ++charCounts[0][s.charAt(i) - 'a'];
      ++charCounts[1][t.charAt(i) - 'a'];
    }

    for (int i = 0; i < charCounts[0].length; i++) {
      if (charCounts[0][i] != charCounts[1][i]) {
        return false;
      }
    }
    return true;
  }
}

/*
time complexity
O(N)

critical point
문자 개수 비교

reference
https://leetcode.com/problems/valid-anagram/
*/
