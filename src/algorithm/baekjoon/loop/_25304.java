package algorithm.baekjoon.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 영수증
 */
public class _25304 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int totalPrice = Integer.parseInt(br.readLine());
    int totalCount = Integer.parseInt(br.readLine());

    int sum = 0;
    for (int i = 0; i < totalCount; i++) {
      String[] priceAndCounts = br.readLine().split(" ");
      sum += Integer.parseInt(priceAndCounts[0]) * Integer.parseInt(priceAndCounts[1]);
    }

    if (sum == totalPrice) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}

/*
260000
4
20000 5
30000 2
10000 6
5000 8
 */