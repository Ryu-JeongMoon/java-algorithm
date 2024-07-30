package algorithm.leetcode.easy;

import java.util.Map;

/**
 * Roman to Integer
 */
public class _13 {

  private static final Map<Character, Integer> CONVERTER = Map.of(
    'I', 1,
    'V', 5,
    'X', 10,
    'L', 50,
    'C', 100,
    'D', 500,
    'M', 1000
  );

  public static void main(String[] args) {
    _13 instance = new _13();

    System.out.println(instance.romanToInt("III")); // 3
    System.out.println(instance.romanToInt("LVIII")); // 58
    System.out.println(instance.romanToInt("MCMXCIV")); // 1994
  }

  public int romanToInt(String s) {
    int sum = 0, index = 0, length = s.length();
    while (index < length) {
      int current = CONVERTER.get(s.charAt(index));
      if (index + 1 < length) {
        int next = CONVERTER.get(s.charAt(index + 1));
        if (current < next) {
          sum += next - 2 * current;
          ++index;
        }
      }

      ++index;
      sum += current;
    }
    return sum;
  }
}

/*
time complexity
O(N)

critical point
CD, CM, XL, XC, IV, IX
작은수/큰수인 경우 => 큰수 - 작은수
앞자리수 보고 뒷자리가 존재한다면 대소 비교 필요

reference
https://leetcode.com/problems/roman-to-integer/
*/
