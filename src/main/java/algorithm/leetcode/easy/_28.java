package algorithm.leetcode.easy;

/**
 * Find the Index of the First Occurrence in a String
 */
public class _28 {

  public static void main(String[] args) {
    _28 instance = new _28();

    System.out.println(instance.strStr("sadbutsad", "sad"));
    System.out.println(instance.strStr("leetcode", "leeto"));
  }

  public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }
}

/*
time complexity
O(N)

critical point

reference
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
*/
