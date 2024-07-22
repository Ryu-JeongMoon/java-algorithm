package algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 */
public class _3 {

  public static void main(String[] args) {
    _3 instance = new _3();

    System.out.println(instance.lengthOfLongestSubstring(" "));
    System.out.println(instance.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(instance.lengthOfLongestSubstring("bbbbb"));
    System.out.println(instance.lengthOfLongestSubstring("pwwkew"));
  }

  public int lengthOfLongestSubstring(String s) {
    int length = s.length(), max = 0;
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
      for (int j = i; j < length; j++) {
        char current = s.charAt(j);
        if (set.contains(current)) {
          break;
        } else {
          set.add(current);
        }
      }

      max = Math.max(max, set.size());
      set.clear();
    }
    return max;
  }
}

/*
time complexity
O(n^2)

critical point
sliding window 개선

reference
https://leetcode.com/problems/longest-substring-without-repeating-characters
*/
