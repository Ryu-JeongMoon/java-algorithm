package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 피로도
 */
public class _22864 {

  public static void main(String[] args) throws IOException {
    int fatigue = 0, fatiguePerWork = nextInt(), totalWork = 0, work = nextInt(), rest = nextInt(), max = nextInt();
    for (int i = 0; i < 24; i++) {
      if (fatigue + fatiguePerWork <= max) {
        totalWork += work;
        fatigue += fatiguePerWork;
      } else {
        fatigue -= rest;
        if (fatigue < 0) {
          fatigue = 0;
        }
      }
    }
    System.out.println(totalWork);
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/22864
*/
