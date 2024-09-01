package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams
 */
public class _49_2 {

  public static void main(String[] args) {
    _49_2 instance = new _49_2();

    System.out.println(instance.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    System.out.println(instance.groupAnagrams(new String[] { "" }));
    System.out.println(instance.groupAnagrams(new String[] { "a" }));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> anagramMap = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      if (anagramMap.containsKey(sorted)) {
        anagramMap.get(sorted).add(str);
      } else {
        anagramMap.put(sorted, new ArrayList<>(List.of(str)));
      }
    }
    return new ArrayList<>(anagramMap.values());
  }
}

/*
time complexity
M = strs.length, N = maximum length of a string in strs
O(M * NlogN)

critical point
애너그램인지 판단하는 기준을 정렬된 문자열로 설정

reference
https://leetcode.com/problems/group-anagrams/
*/
