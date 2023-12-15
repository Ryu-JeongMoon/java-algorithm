package algorithm.solvedac.silver_2;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * 레슬러
 */
public class _1900 {

  private static final FastIO io = new FastIO();

  public static void main(String[] args) throws IOException {
    int n = io.nextInt();
    Wrestler[] wrestlers = new Wrestler[n];
    for (int i = 0; i < n; i++) {
      wrestlers[i] = new Wrestler(i, io.nextInt(), io.nextInt());
    }

    Arrays.sort(wrestlers);
    for (Wrestler wrestler : wrestlers) {
      io.writelnInt(wrestler.index + 1);
    }
    io.flushAndClose();
  }

  private record Wrestler(int index, int power, int ringPower) implements Comparable<Wrestler> {

    @Override
    public int compareTo(Wrestler o) {
      return o.power + o.ringPower * this.power - this.power - this.ringPower * o.power;
    }
  }
}

/*
time complexity
O(NlogN)

critical point
왜 2차원 배열보다 커스텀 클래스 Array.sort가 더 빠른 것인가?
아마도 compareTo를 미리 지정해뒀기 때문?

reference
https://www.acmicpc.net/problem/1900
*/
