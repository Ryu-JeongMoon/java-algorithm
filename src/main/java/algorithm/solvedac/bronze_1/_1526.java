package algorithm.solvedac.bronze_1;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 가장 큰 금민수
 */
public class _1526 {

  public static void main(String[] args) throws IOException {
    String input = new FastIO().readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      int c = input.charAt(i) - '0';
      if (c == 4 || c == 7) {
        sb.append(c);
        continue;
      }

      if (c > 7) {
        fillSeven(sb, input.length() - i);
      } else if (c > 4) {
        sb.append(4);
        fillSeven(sb, input.length() - i - 1);
      } else {
        int lastIndexOfSeven = sb.lastIndexOf("7");
        if (lastIndexOfSeven != -1) {
          sb.delete(lastIndexOfSeven, sb.length());
          sb.append(4);
          fillSeven(sb, input.length() - sb.length());
        } else {
          sb.setLength(0);
          fillSeven(sb, input.length() - 1);
        }
      }
      break;
    }
    System.out.println(sb);
  }

  private static void fillSeven(StringBuilder sb, int length) {
    for (int i = 0; i < length; i++) {
      sb.append("7");
    }
  }
}

/*
time complexity
O(N)

critical point
앞부터 각각의 자리수 판단
1. 7보다 큰 경우, 이전까지의 결과에 남은 길이만큼 7로 채움
ex) 8123 -> 7777, 4831 -> 4777
2. 4보다 큰 경우, 4를 더하고 (남은 길이 - 1)만큼 7로 채움
ex) 5412 -> 4777, 7451 -> 7444
3. 4보다 작은 경우, 자리수를 하나 줄이고 7로 채움
ex) 3412 -> 777, 341 -> 77

reference
https://www.acmicpc.net/problem/1526
*/
