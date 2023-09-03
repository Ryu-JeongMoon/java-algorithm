package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 점수 계산
 */
public class _2822 {

  public static void main(String[] args) throws IOException {
    int[] scores = new int[8];
    for (int i = 0; i < scores.length; i++) {
      scores[i] = nextInt();
    }

    int[] copied = Arrays.copyOf(scores, scores.length);
    Arrays.sort(copied);
    Set<Integer> topScores = new HashSet<>();
    for (int i = 0; i < 5; i++) {
      topScores.add(copied[copied.length - 1 - i]);
    }

    StringBuilder sb = new StringBuilder(topScores.stream().mapToInt(i -> i).sum() + "\n");
    for (int i = 0; i < scores.length; i++) {
      if (topScores.contains(scores[i])) {
        sb.append(i + 1).append(" ");
      }
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(NlogN)

critical point

reference
https://www.acmicpc.net/problem/2822
*/
