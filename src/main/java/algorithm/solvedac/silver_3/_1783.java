package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 병든 나이트
 */
public class _1783 {

  public static void main(String[] args) throws IOException {
    int height = nextInt(), width = nextInt(), count = 0;
    if (height > 2) {
      if (width > 5) {
        count += width - 2;
      } else if (width == 5) {
        count += width - 1;
      } else {
        count += width;
      }
    } else if (height == 2) {
      if (width >= 7) {
        count += 4;
      } else if (width >= 2) {
        count += (width / 2) + (width % 2);
      }
    } else {
      count = 1;
    }
    System.out.println(count);
  }
}

/*
time complexity
O(1)

critical point
복잡한 조건문

reference
https://www.acmicpc.net/problem/1783
*/
