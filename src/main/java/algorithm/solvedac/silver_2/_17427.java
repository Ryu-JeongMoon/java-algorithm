package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 약수의 합 2
 */
public class _17427 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    long sum = 0;
    for (int i = 1; i < n + 1; i++) {
      int divided = n / i;
      sum += i * divided;
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(n)

critical point
1 ~ n까지 약수가 몇번 등장할 것인가?
1 - n번
2 - n/2번
3 - n/3번
...

reference
https://www.acmicpc.net/problem/17427
*/
