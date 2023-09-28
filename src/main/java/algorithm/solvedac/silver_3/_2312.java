package algorithm.solvedac.silver_3;

import static algorithm.util.PrimeUtils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import algorithm.util.FastIO;

/**
 * 수 복원하기
 */
public class _2312 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int[] targets = new int[io.nextInt()];
    for (int i = 0; i < targets.length; i++) {
      targets[i] = io.nextInt();
    }

    List<Integer> primeFactors = new ArrayList<>();
    primeFactors.add(2);
    for (int i = 3; i <= targets[targets.length - 1]; i += 2) {
      if (isPrime(i)) {
        primeFactors.add(i);
      }
    }

    for (int target : targets) {
      for (int primeFactor : primeFactors) {
        if (target == 1) {
          break;
        }
        int count = 0;
        while (target % primeFactor == 0) {
          ++count;
          target /= primeFactor;
        }
        if (count != 0) {
          io.writeInt(primeFactor);
          io.writeBuffer((byte) ' ');
          io.writelnInt(count);
        }
      }
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N * sqrt(N))

critical point
전체 수로 나누지 않고 소인수로 나눠 풀이
1, 2, 3, 4, 5, 6, 7 ... x
2, 3, 5, 7 ...

reference
https://www.acmicpc.net/problem/2312
*/
