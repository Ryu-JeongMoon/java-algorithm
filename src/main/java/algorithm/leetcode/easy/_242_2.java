package algorithm.leetcode.easy;

/**
 * Valid Anagram
 */
public class _242_2 {

  public static void main(String[] args) {
    _242_2 instance = new _242_2();

    System.out.println(instance.isAnagram("anagram", "nagaram"));
    System.out.println(instance.isAnagram("rat", "car"));
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      ++counts[s.charAt(i) - 'a'];
      --counts[t.charAt(i) - 'a'];
    }

    for (int n : counts) {
      if (n != 0) {
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
문자 개수 비교를 부호 사용하여 하나의 배열로 처리

reference
https://leetcode.com/problems/valid-anagram/
*/
