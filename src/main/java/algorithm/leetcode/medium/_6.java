package algorithm.leetcode.medium;

/**
 * Zigzag Conversion
 */
public class _6 {

  public static void main(String[] args) {
    _6 instance = new _6();

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

    int index = 0, length = s.length(), x = 0, y = 0, directionIndex = 0;
    int[][] direction = {
      { 1, 0 },
      { -1, 1 }
    };

    char[][] map = new char[numRows][length];
    while (index != length) {
      map[x][y] = s.charAt(index++);

      int nextX = x + direction[directionIndex][0];
      if (nextX == -1 || nextX == numRows) {
        directionIndex ^= 1;
      }

      x += direction[directionIndex][0];
      y += direction[directionIndex][1];
    }

    StringBuilder sb = new StringBuilder();
    for (char[] chars : map) {
      for (char aChar : chars) {
        if (!Character.isWhitespace(aChar) && aChar != '\u0000') {
          sb.append(aChar);
          if (sb.length() == length) {
            break;
          }
        }
      }
    }

    return sb.toString();
  }
}

/*
time complexity
O(N * numRows)

critical point
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Explanation:
P   A   H   N
A P L S I I G
Y   I   R

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "PAYPALISHIRING", numRows = 5
Output: "PHASIYIRPLIGAN"
Explanation:
P       H
A     S I
Y   I   R
P L     I G
A       N

reference
https://leetcode.com/problems/zigzag-conversion/
*/
