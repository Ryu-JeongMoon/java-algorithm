package algorithm.leetcode.medium;

/**
 * String to Integer (atoi)
 */
public class _8 {

  public static void main(String[] args) {
    _8 instance = new _8();

    System.out.println(instance.myAtoi("42"));
    System.out.println(instance.myAtoi(" -042"));
    System.out.println(instance.myAtoi("1337c0d3"));
    System.out.println(instance.myAtoi("0-1"));
    System.out.println(instance.myAtoi("words and 987"));
    System.out.println(instance.myAtoi("-91283472332"));
    System.out.println(instance.myAtoi(".1"));
    System.out.println(instance.myAtoi(""));
    System.out.println(instance.myAtoi("+1"));
    System.out.println(instance.myAtoi(" "));
    System.out.println(instance.myAtoi("9223372036854775808"));
  }

  public int myAtoi(String s) {
    int length = s.length();
    if (length == 0) {
      return 0;
    }

    int read = 0, index = 0, neg = 1;
    long sum = 0;

    while (index < length && (read = s.charAt(index++)) == ' ') {
    }

    if (read == '-') {
      neg = -1;
    } else if (Character.isDigit(read)) {
      sum = read - '0';
    } else if (read != '+') {
      return 0;
    }

    while (index < length && Character.isDigit(read = s.charAt(index++)) && sum < Integer.MAX_VALUE) {
      sum = sum * 10 + read - '0';
    }

    if (sum > Integer.MAX_VALUE) {
      return neg == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }
    return (int) (sum * neg);
  }
}

/*
time complexity
O(N)

critical point
1ms, Beats 100.00%

reference
https://leetcode.com/problems/string-to-integer-atoi/
*/
