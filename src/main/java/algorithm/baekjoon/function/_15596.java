package algorithm.baekjoon.function;

/**
 * 정수 N개의 합
 */
public class _15596 {

  long sum(int[] a) {
    long result = 0;
    for (int i : a) {
      result += i;
    }
    return result;
  }
}

/*
(0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
 */