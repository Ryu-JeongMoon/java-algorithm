package algorithm.leetcode.easy;

/**
 * Longest Common Prefix
 */
public class _14 {

  public static void main(String[] args) {
    _14 instance = new _14();

    System.out.println(instance.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    System.out.println(instance.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
    System.out.println(instance.longestCommonPrefix(new String[] { "", "b" }));
    System.out.println(instance.longestCommonPrefix(new String[] { "flower", "flower", "flower", "flower" }));
  }

  public String longestCommonPrefix(String[] strs) {
    int countOfWords = strs.length, max = 0, maxIndex = 0;
    int[] lengths = new int[countOfWords];
    for (int i = 0; i < countOfWords; i++) {
      lengths[i] = strs[i].length();
      if (max < lengths[i]) {
        max = lengths[i];
        maxIndex = i;
      }
    }

    int index = 0;
    StringBuilder sb = new StringBuilder();
    outer:
    for (int i = 0; i < max; i++) {
      char c = strs[maxIndex].charAt(index);
      for (int j = 0; j < countOfWords; j++) {
        int currentLength = lengths[j];
        if (j != maxIndex && (index >= currentLength || strs[j].charAt(index) != c)) {
          break outer;
        }
      }
      sb.append(strs[maxIndex].charAt(index++));
    }

    return sb.toString();
  }
}

/*
time complexity
L = max(strs[i].length())
O(N * L)

critical point
예외값, 범위값 주의

reference
https://leetcode.com/problems/longest-common-prefix/
*/
