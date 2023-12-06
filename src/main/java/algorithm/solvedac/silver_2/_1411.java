package algorithm.solvedac.silver_2;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 비슷한 단어
 */
public class _1411 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    String[] words = new String[io.nextInt()];
    for (int i = 0; i < words.length; i++) {
      words[i] = io.readLine();
    }
    int count = 0;
    for (int currentIndex = 0; currentIndex < words.length - 1; currentIndex++) {
      for (int nextIndex = currentIndex + 1; nextIndex < words.length; nextIndex++) {
        count += getCount(words[currentIndex], words[nextIndex]);
      }
    }
    io.writeInt(count);
    io.flushAndClose();
  }

  private static int getCount(String current, String next) {
    boolean broken = false;
    for (int k = 0; k < current.length(); k++) {
      char currentLetter = current.charAt(k);
      char nextLetter = next.charAt(k);

      int currentIndex = k, nextIndex = k;
      while (currentIndex == nextIndex && currentIndex != -1) {
        currentIndex = current.indexOf(currentLetter, currentIndex + 1);
        nextIndex = next.indexOf(nextLetter, nextIndex + 1);
      }

      if (currentIndex != nextIndex) {
        broken = true;
        break;
      }
    }
    return broken ? 0 : 1;
  }
}

/*
time complexity
O(N^2)

critical point
비슷한 패턴을 찾기 위해 동일한 값을 갖는 인덱스 조회

reference
https://www.acmicpc.net/problem/1411
*/
