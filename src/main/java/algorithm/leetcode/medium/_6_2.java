package algorithm.leetcode.medium;

/**
 * Zigzag Conversion
 */
public class _6_2 {

  public static void main(String[] args) {
    _6_2 instance = new _6_2();

    System.out.println(instance.convert("AB", 1));
    System.out.println(instance.convert("PAYPALISHIRING", 3));
    System.out.println(instance.convert("PAYPALISHIRING", 4));
    System.out.println(
      instance.convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 2));
  }

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    int index = 0, operand = 1, currentLength = 0, length = s.length();
    StringBuilder[] builders = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      builders[i] = new StringBuilder();
    }

    while (currentLength != length) {
      builders[index].append(s.charAt(currentLength++));

      if (index + operand == -1) {
        operand = 1;
      } else if (index + operand == numRows) {
        operand = -1;
      }
      index += operand;
    }

    StringBuilder result = new StringBuilder();
    for (StringBuilder builder : builders) {
      result.append(builder);
    }
    return result.toString();
  }
}

/*
time complexity
O(N)

critical point
4ms, Beats 82.30%

reference
https://leetcode.com/problems/zigzag-conversion/
*/
