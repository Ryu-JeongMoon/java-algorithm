package algorithm.solvedac.silver_1;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 골드바흐의 추측
 */
public class _6588 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int length = 1000001;
    boolean[] compositeNumbers = new boolean[length];
    int end = (int) Math.sqrt(length) + 1;
    for (int i = 3; i < end; i += 2) {
      if (!compositeNumbers[i]) {
        int interval = 2 * i;
        for (int j = i * i; j < length; j += interval) {
          if (!compositeNumbers[j]) {
            compositeNumbers[j] = true;
          }
        }
      }
    }

    int input;
    outer:
    while ((input = io.nextInt()) != 0) {
      for (int i = 3; i <= input / 2; i += 2) {
        if (!compositeNumbers[i] && !compositeNumbers[input - i]) {
          io.writeln(input + " = " + i + " + " + (input - i));
          continue outer;
        }
      }
      io.writeln("Goldbach's conjecture is wrong.");
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N*log(log(N)))

critical point
while 문 안 for 문의 범위 주의
6 = 3 + 3

reference
https://www.acmicpc.net/problem/6588
*/
