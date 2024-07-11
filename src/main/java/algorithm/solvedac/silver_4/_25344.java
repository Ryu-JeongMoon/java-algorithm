package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;
import static org.apache.commons.math3.util.ArithmeticUtils.gcd;

import java.io.IOException;

/**
 * 행성 정렬
 */
public class _25344 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    long target = 1;
    for (int i = 0; i < n - 2; i++) {
      int current = nextInt();
      long gcd = gcd(Math.max(target, current), Math.min(target, current));
      target = current * target / gcd;
    }
    System.out.println(target);
  }
}

/*
time complexity
O(N)

critical point
num = index => 0, 1... n의 곱
gcd = index => 0, 1... n의 최소공배수
일치하는 주기 = num / gcd

전체 곱을 하면 long 범위도 벗어날 가능성이 있으므로 매번 계산

reference
https://www.acmicpc.net/problem/25344
*/
