package algorithm.solvedac.silver_4;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 사탕
 */
public class _1812 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int[] aggregates = new int[io.nextInt()], numbers = new int[aggregates.length + 1];
    int sum = 0, sumExceptFirst = 0;
    for (int i = 0; i < aggregates.length; i++) {
      aggregates[i] = io.nextInt();
      sum += aggregates[i];
      if (i % 2 != 0) {
        sumExceptFirst += aggregates[i];
      }
    }

    numbers[0] = sum / 2 - sumExceptFirst;
    for (int i = 0; i < aggregates.length; i++) {
      numbers[i + 1] = aggregates[i] - numbers[i];
      io.writelnInt(numbers[i]);
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
1. 전체 합을 더해줌 = 2 * (A1 + A2 ... + An)
2. 홀수 번째 합을 더해줌 = (A2 + A3 + ... + An)
3. (전체 합 / 2)에서 홀수 번째 합을 빼 A1을 구함
4. 전체 순회, A1 + A2 - A1 = A2, A2 + A3 - A2 = A3, ... , An-1 + An - An-1 = An 식으로 모든 값을 구해줌

로직 자체는 틀리지 않으나 StringBuilder, System.out.println 으로 출력 시 시간 초과 발생

reference
https://www.acmicpc.net/problem/1812
*/
