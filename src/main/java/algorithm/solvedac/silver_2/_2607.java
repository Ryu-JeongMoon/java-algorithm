package algorithm.solvedac.silver_2;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 비슷한 단어
 */
public class _2607 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt() - 1, count = 0;

    String source = io.readLine();
    int[] control = new int[26], experiment;
    for (int i = 0; i < source.length(); i++) {
      ++control[source.charAt(i) - 'A'];
    }

    for (int i = 0; i < n; i++) {
      String target = io.readLine();
      if (Math.abs(target.length() - source.length()) > 1) {
        continue;
      }

      experiment = new int[26];
      for (int j = 0; j < target.length(); j++) {
        ++experiment[target.charAt(j) - 'A'];
      }

      int diff = 0;
      for (int j = 0; j < control.length; j++) {
        diff += Math.abs(control[j] - experiment[j]);
        if (diff > 2) {
          break;
        }
      }

      if (diff < 3) {
        ++count;
      }
    }

    io.writelnInt(count);
    io.flushAndClose();
  }
}

/*
time complexity
l = length of input
O(n * l)

critical point
길이 차이가 2 미만이고 알파벳 차이가 2 이하인 경우 count 증가

reference
https://www.acmicpc.net/problem/2607
*/
