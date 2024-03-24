package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 1
 */
public class _4375 {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int n;
    while ((n = nextInt()) != 0) {
      for (int i = 1, value = 0; ; i++) {
        value = (value * 10 + 1) % n;
        if (value == 0) {
          sb.append(i).append("\n");
          break;
        }
      }
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(n)

critical point
계속해서 자릿수가 늘어나는 1, 11, 111 을 기준으로 잡으면 long 범위를 벗어남
1, 11, 111 에 % 연산을 가한 나머지로 기준을 잡아야 int 범위를 벗어나지 않고 연산 가능

1 % n = 1 % n
11 % n = (1 * 10 + 1) % n
111 % n = (11 * 10 + 1) % n
1111 % n = (111 * 10 + 1) % n

reference
https://www.acmicpc.net/problem/4375
*/
