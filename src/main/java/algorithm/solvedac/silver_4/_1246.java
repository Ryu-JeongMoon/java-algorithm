package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * 온라인 판매
 */
public class _1246 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();
    int[] candidates = new int[m];
    for (int i = 0; i < m; i++) {
      candidates[i] = nextInt();
    }
    Arrays.sort(candidates);

    int price = 0, revenue = 0;
    for (int i = 0; i < m; i++) {
      int countOfPerson = Math.min(n, m - i);
      int totalRevenue = candidates[i] * countOfPerson;
      if (revenue < totalRevenue) {
        revenue = totalRevenue;
        price = candidates[i];
      }
    }
    System.out.println(price + " " + revenue);
  }
}

/*
time complexity
O(NlogN)

critical point
달걀 수가 사람 수보다 적은 경우 고려

reference
https://www.acmicpc.net/problem/1246
*/
