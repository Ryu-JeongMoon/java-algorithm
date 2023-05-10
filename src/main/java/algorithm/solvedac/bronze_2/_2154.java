package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수 이어 쓰기 3
 */
public class _2154 {

  public static void main(String[] args) throws IOException {
    String objective = new BufferedReader(new InputStreamReader(System.in)).readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < Integer.parseInt(objective) + 1; i++) {
      sb.append(i);
    }
    System.out.println(sb.indexOf(objective) + 1);
  }
}

/*
time complexity
O(n)

critical point
굳이 어렵게 풀 필요 없듬

reference
https://www.acmicpc.net/problem/2154
 */
