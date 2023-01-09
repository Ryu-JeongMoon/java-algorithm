package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 삼각 김밥
 */
public class _2783 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    double cheapest = (double) Integer.parseInt(s[0]) / Integer.parseInt(s[1]);
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String[] priceAndWeight = br.readLine().split(" ");
      double value = (double) Integer.parseInt(priceAndWeight[0]) / Integer.parseInt(priceAndWeight[1]);
      if (cheapest > value) {
        cheapest = value;
      }
    }
    System.out.printf("%.2f\n", 1000 * cheapest);
  }
}

/*
time complexity
O(n)

critical point
삼각 김밥 Y그램 당 X원, 정답과의 오차는 0.01까지 허용

reference
https://www.acmicpc.net/problem/2783
 */