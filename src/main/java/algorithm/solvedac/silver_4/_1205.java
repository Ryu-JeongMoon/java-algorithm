package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 등수 구하기
 */
public class _1205 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), score = nextInt(), p = nextInt(), rank = 1;
    List<Integer> scores = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      scores.add(nextInt());
    }

    if (p <= scores.size() && score <= scores.getLast()) {
      System.out.println(-1);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (score > scores.get(i)) {
        rank = i + 1;
        break;
      } else {
        ++rank;
      }
    }
    System.out.println(rank <= p ? rank : -1);
  }
}

/*
time complexity
O(n)

critical point
동점인 경우 등수 주의

reference
https://www.acmicpc.net/problem/1205
*/
