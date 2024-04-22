package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 중복 빼고 정렬하기
 */
public class _10867 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(nextIntWithNegative());
    }

    StringBuilder sb = new StringBuilder();
    for (Integer i : set) {
      sb.append(i).append(' ');
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/10867
*/
