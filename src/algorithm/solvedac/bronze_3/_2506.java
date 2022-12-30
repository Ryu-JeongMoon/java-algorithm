package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 점수계산
 */
public class _2506 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    int point = 1, sum = 0;
    for (char c : br.readLine().toCharArray()) {
      if (c == '0') {
        point = 1;
      } else if (c == '1') {
        sum += point++;
      }
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(N)

critical point
0이 나오면 point 1로 초기화

reference
https://www.acmicpc.net/problem/2506
 */