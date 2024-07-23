package algorithm.leetcode.medium;

/**
 * Integer to Roman
 */
public class _12 {

  private static final char[][] ROMAN = {
    { 'I', 'V' },
    { 'X', 'L' },
    { 'C', 'D' },
    { 'M' }
  };

  public static void main(String[] args) {
    _12 instance = new _12();

    System.out.println(instance.intToRoman(3749));
    System.out.println(instance.intToRoman(58));
    System.out.println(instance.intToRoman(1994));
  }

  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();

    int base = 1000, digitPlace = 3;
    while (base != 0) {
      int target = num / base;
      if (target == 0) {
        base /= 10;
        --digitPlace;
        continue;
      }

      if (target == 9) {
        sb.append(ROMAN[digitPlace][0]).append(ROMAN[digitPlace + 1][0]);
      } else if (target > 4) {
        sb.append(ROMAN[digitPlace][1]);
        for (int i = 5; i < target; i++) {
          sb.append(ROMAN[digitPlace][0]);
        }
      } else if (target == 4) {
        sb.append(ROMAN[digitPlace][0]).append(ROMAN[digitPlace][1]);
      } else {
        for (int i = 0; i < target; i++) {
          sb.append(ROMAN[digitPlace][0]);
        }
      }

      num %= base;
      base /= 10;
      --digitPlace;
    }

    return sb.toString();
  }
}

/*
time complexity
O(1)

critical point

reference
https://leetcode.com/problems/integer-to-roman/
*/
