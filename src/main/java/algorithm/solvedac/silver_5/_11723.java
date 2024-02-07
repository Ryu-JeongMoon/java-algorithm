package algorithm.solvedac.silver_5;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 집합
 */
public class _11723 {

  @SuppressWarnings("StatementWithEmptyBody")
  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt(), bit = 0;

    while (--n >= 0) {
      switch ((char) io.read()) {
        case 'a' -> {
          byte secondLetter = io.read();
          if (secondLetter == 'd') {
            while (io.read() != ' ') ;
            bit |= 1 << io.nextInt() - 1;
          } else {
            bit = (1 << 20) - 1;
            while (io.read() != '\n') ;
          }
        }
        case 'c' -> {
          while (io.read() != ' ') ;
          io.writelnInt((bit & 1 << io.nextInt() - 1) != 0 ? 1 : 0);
        }
        case 'e' -> {
          while (io.read() != '\n') ;
          bit = 0;
        }
        case 'r' -> {
          while (io.read() != ' ') ;
          bit &= ~(1 << io.nextInt() - 1);
        }
        case 't' -> {
          while (io.read() != ' ') ;
          bit ^= 1 << io.nextInt() - 1;
        }
      }
    }
    io.flushBuffer();
  }
}

/*
time complexity
O(N)

critical point
비트 연산의 이해

reference
https://www.acmicpc.net/problem/11723
*/
