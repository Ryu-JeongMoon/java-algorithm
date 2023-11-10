package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 약속
 */
public class _1183 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    if (n % 2 == 1) {
      System.out.println(1);
      return;
    }
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = nextInt() - nextInt();
    }
    Arrays.sort(numbers);
    System.out.println(Math.abs(numbers[n / 2 - 1] - numbers[n / 2]) + 1);
  }
}

/*
time complexity
O(NlogN)

critical point
계산 범위 주의, 일일이 계산하려 하면 -10^9 ~ 10^9 범위를 계산해야 해서 시간 초과
홀수인 경우, 최저점이 1개
짝수인 경우, 값이 늘어나는 원소 개수와 값이 줄어드는 원소 개수 비교

   -3 -2 -1  0  1  2  3  4
-5  8  7  6  5  4  3  2  1
-5  8  7  6  5  4  3  2  1
-3  6  5  4  3  2  1  0  1
 2  1  0  1  2  3  4  5  6
 4  1  2  3  4  5  6  7  8
 6  3  4  5  6  7  8  9  10

-2부터 줄어드는 개수 : 3개, 늘어나는 개수 : 2개 (0은 제외)
 3부터 줄어드는 개수 : 2개, 늘어나는 개수 : 3개 (0은 제외)

계속해서 줄다가 -2에서 최저점을 찍고
줄어드는 개수와 늘어나는 개수의 힘의 균형이 맞춰진 후
3에서 균형이 다시 깨져 늘어나는 개수가 줄어드는 개수가 많아진다
단 경계값까지는 1 -> 0으로 줄어들었으므로 범위에 포함

result = Math.abs(array[n/2-1] - array[n/2]) + 1

reference
https://www.acmicpc.net/problem/1183
*/
