package algorithm.programmers.level2;

import static algorithm.util.MathUtils.*;

/**
 * N개의 최소공배수
 */
public class _12953 {

  public static void main(String[] args) {
    _12953 instance = new _12953();
    System.out.println(instance.solution(new int[] { 2, 6, 8, 14 }));
    System.out.println(instance.solution(new int[] { 1, 2, 3 }));
  }

  public int solution(int[] arr) {
    int lcm = 1;
    for (int i : arr) {
      lcm *= i / gcd(lcm, i);
    }
    return lcm;
  }
}

/*
time complexity
O(N)

critical point
최소공배수 계산의 누적

reference
https://programmers.co.kr/learn/courses/30/lessons/12953
*/
