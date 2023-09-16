package algorithm.solvedac.silver_4;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 수들의 합 2
 */
public class _2003 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int[] array = new int[io.nextInt()];
    long target = io.nextLong();
    for (int i = 0; i < array.length; i++) {
      array[i] = io.nextInt();
    }

    int count = 0, previousIndex = 0;
    long sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
      if (sum == target) {
        ++count;
      } else if (sum > target) {
        sum -= (array[i--] + array[previousIndex++]);
      }
    }
    io.writeInt(count);
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
2중 순회 하지 않고 더한 값의 맨 앞 자리와 현재 순서의 더한 값을 빼주고
인덱스를 하나 감소 시켜 동일한 로직을 탈 수 있도록 함

1 2 3 4
4까지 더했을 때 sum > target 인 경우
sum에서 1, 4를 빼주고 인덱스도 줄여 sum에 4를 더하는 로직부터 다시 시작

reference
https://www.acmicpc.net/problem/2003
*/
