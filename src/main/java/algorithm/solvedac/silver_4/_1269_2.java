package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 대칭 차집합
 */
public class _1269_2 {

  public static void main(String[] args) throws IOException {
    int a = nextIntWithNegative(), b = nextIntWithNegative(), total = a + b;
    Set<Integer> elements = new HashSet<>(Math.max(a, b));
    for (int i = 0; i < total; i++) {
      elements.add(nextIntWithNegative());
    }
    System.out.println(2 * elements.size() - total);
  }
}

/*
time complexity
O(n)

critical point
1. hashset 초기 capacity 지정, doubling 최대 한번 발생
2. 중복 제거 합집합 * 2 - 전체 원소 수 = 대칭 차집합 원소 수

reference
https://www.acmicpc.net/problem/1269
*/
