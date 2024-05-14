package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.Arrays;

/**
 * 스네이크버드
 */
public class _16435 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), l = nextInt();
    int[] heightOfFruits = new int[n];
    for (int i = 0; i < n; i++) {
      heightOfFruits[i] = nextInt();
    }
    Arrays.sort(heightOfFruits);
    for (int heightOfFruit : heightOfFruits) {
      if (l >= heightOfFruit) {
        l++;
      } else {
        break;
      }
    }
    System.out.println(l);
  }
}

/*
time complexity
O(NlogN)

critical point
과일의 높이는 정렬되어 있지 않음

reference
https://www.acmicpc.net/problem/16435
*/
