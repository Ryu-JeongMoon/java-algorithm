package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 메시지
 */
public class _1384 {

  private static final String TEMPLATE = "%s was nasty about %s";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int groupNumber = 0;
    StringBuilder sb = new StringBuilder();
    while (true) {
      String sol = receivePerGroup(br, ++groupNumber);
      if (sol.equals("")) {
        break;
      } else {
        sb.append(sol).append("\n");
      }
    }
    System.out.print(sb);
  }

  private static String receivePerGroup(BufferedReader br, int groupNumber) throws IOException {
    int n = Integer.parseInt(br.readLine());
    if (n == 0) {
      return "";
    }

    String[] names = new String[n];
    boolean[][] isNasty = new boolean[n][n - 1];
    for (int i = 0; i < n; i++) {
      String[] s = br.readLine().split(" ");
      names[i] = s[0];
      for (int j = 1; j < n; j++) {
        if (s[j].equals("N")) {
          isNasty[i][j - 1] = true;
        }
      }
    }

    StringBuilder sb = new StringBuilder("Group " + groupNumber + "\n");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (isNasty[i][j]) {
          // i를 기준으로 1 감소시킨 인덱스를 표현하기 위해 n - 1 + i
          sb.append(String.format(TEMPLATE, names[(n - 1 + i - j) % n], names[i])).append("\n");
        }
      }
    }

    String result = sb.toString();
    return result.equals("Group " + groupNumber + "\n")
      ? result + "Nobody was nasty\n"
      : result;
  }
}

/*
time complexity
O(N^2)

critical point
Nasty 배열의 인덱스 일반화하는 것이 관건
자신의 인덱스를 기준으로 -1씩 감소하며 정렬된 상태
Ann   = names[0], Ann's Nasty index   = [4, 3, 2, 1]
Bob   = names[1], Bob's Nasty index   = [0, 4, 3, 2]
Clive = names[2], Clive's Nasty index = [1, 0, 4, 3]
...

1. 전체 인덱스에서 1 감소 시킨 인덱스(n-1) + 자신의 인덱스(i) - 감소해나가는 인덱스(j)
2. 인덱스 범위를 초과하면 안 되므로 % n 필요

reference
https://www.acmicpc.net/problem/1384
 */