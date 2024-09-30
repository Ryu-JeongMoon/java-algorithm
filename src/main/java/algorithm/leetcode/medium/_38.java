package algorithm.leetcode.medium;

/**
 * Count and Say
 */
public class _38 {

  public static void main(String[] args) {
    _38 instance = new _38();

    for (int i = 1; i <= 30; i++) {
      System.out.println(instance.countAndSay(i));
    }
  }

  public String countAndSay(int n) {
    StringBuilder result = new StringBuilder("1");
    for (int i = 2; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      char initial = result.charAt(0);
      int count = 0;

      for (int j = 0; j < result.length(); j++) {
        char current = result.charAt(j);
        if (current == initial) {
          ++count;
        } else {
          sb.append(count).append(initial);
          initial = current;
          count = 1;
        }
      }

      sb.append(count).append(initial);
      result.setLength(0);
      result.append(sb);
    }
    return result.toString();
  }
}

/*
time complexity
O(1.3ⁿ)

critical point

reference
https://leetcode.com/problems/count-and-say/
*/
