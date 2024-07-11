package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 바지 구매
 */
public class _25338 {

  public static void main(String[] args) throws IOException {
    int a = nextIntWithNegative(), b = nextIntWithNegative(), c = nextIntWithNegative(), d = nextIntWithNegative(), n = nextIntWithNegative(), count = 0;
    for (int i = 0; i < n; i++) {
      int pantsWidth = nextIntWithNegative(), pantsHeight = nextIntWithNegative();
      int max = Math.max(a * (pantsHeight - b) * (pantsHeight - b) + c, d);
      if (pantsWidth == max) {
        ++count;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(1)

critical point
f(x) = Math.max(a(x-b)^2 + c, d)

1. 입력으로 받은 바지를 입었을 때
2. 시루의 하체 둘레 공식에 바지 길이를 인자로 넣어 하체 둘레를 구하고
3. 입력으로 받은 하체 둘레와 같다면 카운트

reference
https://www.acmicpc.net/problem/25338
*/
