package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 거스름돈
 */
public class _14916 {

  public static void main(String[] args) throws IOException {
    int amount = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    if (amount < 5 && amount % 2 != 0) {
      System.out.println(-1);
      return;
    }

    int remains = amount % 5;
    if (remains % 2 == 0) {
      System.out.println((amount / 5) + (remains / 2));
    } else {
      System.out.println((amount / 5) - 1 + ((remains + 5) / 2));
    }
  }
}

/*
time complexity
O(1)

critical point
5 이상의 수는 5와 2로 모두 표현 가능
1. 입력값을 5로 나눈 나머지가 2로 나누어 떨어지면 5로 전부 표현
2. 나누어 떨어지지 않는 경우
   5로 나눈 몫에서 1을 뺌
   나머지에 5를 더한 후 2로 나눔

13
13 / 5 = 2, 13 % 5 = 3
5, 2로 표현 불가, 2번 케이스로 바꾸어 표현
5 * (2 - 1) + 2 * ((3 + 5) / 2) = 13
5 - 1개, 2 - 4개로 표현 가능

reference
https://www.acmicpc.net/problem/14916
*/
