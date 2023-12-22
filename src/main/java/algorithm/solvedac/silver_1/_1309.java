package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 동물원
 */
public class _1309 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), prev1 = 1, prev2 = 3, sum = 3;
    for (int i = 1; i < n; i++) {
      sum = (prev1 + prev2 * 2) % 9901;
      prev1 = prev2;
      prev2 = sum;
    }
    System.out.println(sum);
  }
}

/*
time complexity
O(n)

critical point
BigInteger 사용 시 메모리 초과 발생
직접 연산으로 풀리지 않는 경우 점화식 찾아야 함

reference
https://www.acmicpc.net/problem/1309
*/
