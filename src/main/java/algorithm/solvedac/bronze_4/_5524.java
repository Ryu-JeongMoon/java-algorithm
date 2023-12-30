package algorithm.solvedac.bronze_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 입실 관리
 */
public class _5524 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(br.readLine().toLowerCase()).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/5524
*/
