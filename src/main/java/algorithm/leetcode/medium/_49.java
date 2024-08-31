package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Group Anagrams
 */
public class _49 {

  public static void main(String[] args) {
    _49 instance = new _49();

    System.out.println(instance.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    System.out.println(instance.groupAnagrams(new String[] { "" }));
    System.out.println(instance.groupAnagrams(new String[] { "a" }));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    int length = strs.length;
    boolean[] visited = new boolean[length];

    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      String current = strs[i];
      List<String> group = new ArrayList<>();
      group.add(current);

      int[] currentCounts = getCharCounts(current);
      for (int j = i + 1; j < length; j++) {
        if (visited[j] || current.length() != strs[j].length()) {
          continue;
        }
        if (Arrays.equals(currentCounts, getCharCounts(strs[j]))) {
          visited[j] = true;
          group.add(strs[j]);
        }
      }

      result.add(group);
    }
    return result;
  }

  private int[] getCharCounts(String str) {
    int[] charCounts = new int[26];
    for (char c : str.toCharArray()) {
      ++charCounts[c - 'a'];
    }
    return charCounts;
  }
}

/*
time complexity
O(n^2)

critical point
애너그램인지 판단하는 기준을 문자열의 길이와 문자의 개수로 설정
각 문자마다 26개짜리 배열을 만드므로 시간, 공간 비효율적

reference
https://leetcode.com/problems/group-anagrams/
*/
