package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * K번째 수
 */
public class _11004 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative(), k = nextIntWithNegative();
    List<Integer> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      list.add(nextIntWithNegative());
    }
    list.sort(null);
    System.out.println(list.get(k - 1));
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/11004
*/
