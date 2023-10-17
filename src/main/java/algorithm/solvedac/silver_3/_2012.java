package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 등수 매기기
 */
public class _2012 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] input = new int[500001];
    for (int i = 0; i < n; i++) {
      ++input[nextInt()];
    }

    int i = 1, j = 1;
    long sum = 0;
    while (i != input.length) {
      if (input[i] == 0) {
        ++i;
      } else {
        --input[i];
        sum += Math.abs(i - j++);
      }
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(N)

critical point
two pointer
불만 지수를 최소화 (불만 지수는 |예상 등수 - 실제 등수|)
i와 j로 포인터 나눠 조건에 만족 되지 않으면 j를 진행 시키지 않고 i를 진행 시켜
1 이상의 값을 만났을 때 j를 진행

reference
https://www.acmicpc.net/problem/2012
*/
