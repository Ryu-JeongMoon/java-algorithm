package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 카드1
 */
public class _2161 {

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
    if (n == 1) {
      System.out.println(1);
      return;
    }

    solution1(n);
    solution2(n);
  }

  private static void solution1(int n) {
    StringBuilder sb = new StringBuilder();
    boolean isOdd = n % 2 != 0;
    int oddLength = isOdd ? n / 2 + 1 : n / 2;
    int evenLength = n - oddLength;
    for (int i = 0; i < oddLength; i++) {
      sb.append(2 * i + 1).append(" ");
    }

    int[] evenCards = new int[evenLength * 2];
    if (isOdd) {
      for (int i = 0; i < evenLength - 1; i++) {
        evenCards[i] = 2 * i + 4;
      }
      evenCards[evenLength - 1] = 2;
    } else {
      for (int i = 0; i < evenLength; i++) {
        evenCards[i] = 2 * i + 2;
      }
    }
    System.out.println(sb.append(getResult(evenLength, evenCards, new int[evenLength])));
  }

  private static void solution2(int n) {
    int[] cards = new int[2 * n], discardedCards = new int[n];
    for (int i = 0; i < n; i++) {
      cards[i] = i + 1;
    }
    System.out.println(getResult(n, cards, discardedCards));
  }

  private static StringBuilder getResult(int n, int[] cards, int[] discardedCards) {
    int length = n, discardedCardIndex = 0, originalCardIndex = 0;
    while (length-- > 0) {
      discardedCards[discardedCardIndex] = cards[originalCardIndex];
      cards[n + discardedCardIndex++] = cards[originalCardIndex + 1];
      originalCardIndex += 2;
    }
    StringBuilder sb = new StringBuilder();
    for (int card : discardedCards) {
      sb.append(card).append(" ");
    }
    return sb;
  }
}

/*
time complexity
O(N)

critical point
입력값 짝수인 경우 정순 -> 2 4 6 8
입력값 홀수인 경우 맨 앞자리가 맨 뒤로 간 형태 -> 4 6 2

규칙은 홀수 먼저 출력 후 남은 짝수들은 섞는 과정을 겪고 출력
전체 배열을 돌리지 않도록 찔끔 최적화하여 짝수 배열에만 섞는 작업을 수행했으나 속도 빨라지지 않음
sol1 -> 80ms, sol2 -> 80ms

reference
https://www.acmicpc.net/problem/2161
 */