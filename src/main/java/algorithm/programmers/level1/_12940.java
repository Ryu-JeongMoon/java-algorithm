package algorithm.programmers.level1;

import java.util.Arrays;

import algorithm.util.MathUtils;

/**
 * 최대공약수와 최소공배수
 */
public class _12940 {

  public static void main(String[] args) {
    _12940 instance = new _12940();
    System.out.println(Arrays.toString(instance.solution(3, 12)));
    System.out.println(Arrays.toString(instance.solution(2, 5)));
  }

  public int[] solution(int n, int m) {
    int gcd = MathUtils.gcd(Math.max(n, m), Math.min(n, m));
    return new int[] { gcd, n * m / gcd };
  }
}

/*
time complexity
O(log(min(n, m)))

critical point
최대공약수의 이해

reference
https://programmers.co.kr/learn/courses/30/lessons/12940
*/
