package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 하키
 */
public class _1358 {

  public static void main(String[] args) throws IOException {
    int w = nextIntWithNegative(), h = nextIntWithNegative(), x = nextIntWithNegative(), y = nextIntWithNegative(), p = nextIntWithNegative(), count = 0;
    for (int i = 0; i < p; i++) {
      int currentX = nextIntWithNegative(), currentY = nextIntWithNegative();
      if (y + h < currentY || currentY < y) {
        continue;
      }

      if (currentX < x && getDistance(currentX, currentY, x, y + h / 2) > h / 2
        || currentX > x + w && getDistance(currentX, currentY, x + w, y + h / 2) > h / 2) {
        continue;
      }
      ++count;
    }
    System.out.println(count);
  }

  private static double getDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
  }
}

/*
time complexity
O(N)

critical point
특정 좌표에서 원까지 이르는 거리 판단

reference
https://www.acmicpc.net/problem/1358
*/
