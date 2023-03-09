package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세준세비
 */
public class _1524 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    br.readLine();
    String line;
    while ((line = br.readLine()) != null) {
      if (line.equals("")) {
        continue;
      }
      String result = getMaxValue(br.readLine().split(" ")) >= getMaxValue(br.readLine().split(" ")) ? "S" : "B";
      sb.append(result).append("\n");
    }
    System.out.print(sb);
  }

  private static int getMaxValue(String[] strings) {
    int max = Integer.MIN_VALUE;
    for (String s : strings) {
      if (max < Integer.parseInt(s)) {
        max = Integer.parseInt(s);
      }
    }
    return max;
  }
}

/*
time complexity
O(n)

critical point
제일 약한 병사가 여러 명이고, 양 편에 모두 있다면 세비의 제일 약한 병사 중 한 명이 임의로 선택되어 죽는다.

reference
https://www.acmicpc.net/problem/1524
 */
