package algorithm.leetcode.medium;

/**
 * Multiply Strings
 */
public class _43_2 {

  public static void main(String[] args) {
    _43_2 instance = new _43_2();

    System.out.println(instance.multiply("0", "0"));
    System.out.println(instance.multiply("99", "9"));
    System.out.println(instance.multiply("2", "3"));
    System.out.println(instance.multiply("123", "456"));
  }

  public String multiply(String num1, String num2) {
    int length1 = num1.length(), length2 = num2.length();
    int[] numbers = new int[length1 + length2];
    for (int i = length1 - 1; i >= 0; i--) {
      for (int j = length2 - 1; j >= 0; j--) {
        int pos1 = i + j + 1;
        int pos2 = i + j;

        int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + numbers[pos1];
        numbers[pos1] = sum % 10;
        if (pos2 >= 0) {
          numbers[pos2] += sum / 10;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int number : numbers) {
      if (!sb.isEmpty() || number != 0) {
        sb.append(number);
      }
    }
    return sb.isEmpty() ? "0" : sb.toString();
  }
}

/*
time complexity
O(N * M)

critical point

reference
https://leetcode.com/problems/multiply-strings/
*/
