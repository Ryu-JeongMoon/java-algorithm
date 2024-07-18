package algorithm.solvedac.silver_4;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 오셀로 재배치
 */
public class _13413 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int t = io.nextInt();
    for (int i = 0; i < t; i++) {
      int n = io.nextInt(), singleCharCount = 0, positionDiff = 0;
      char[] source = io.readLine().toCharArray();
      char[] target = io.readLine().toCharArray();
      for (int j = 0; j < n; j++) {
        char sourceChar = source[j];
        if (sourceChar == 'B') {
          ++singleCharCount;
        }

        char targetChar = target[j];
        if (targetChar == 'B') {
          --singleCharCount;
        }

        if (sourceChar != targetChar) {
          ++positionDiff;
        }
      }

      singleCharCount = Math.abs(singleCharCount);
      int diffCount = Math.min(singleCharCount, n - singleCharCount);
      if (diffCount >= positionDiff) {
        io.writelnInt(diffCount);
      } else {
        io.writelnInt(diffCount + (positionDiff - diffCount) / 2);
      }
    }

    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
1. source, target 'B' 개수가 다르다면 개수를 먼저 맞춰줘야 함
total += charDiff;
2. 'B' 개수를 맞춰줄 때 'B' / 'W' 위치가 다른 곳에 넣으면 되니 다른 위치 개수 조정 필요
position -= charDiff;
3. 2번까지 진행 후에도 position 남아있다면 (positionDiff/2) 만큼 추가 필요
서로 다른 위치를 바꾸는 게 하나의 연산이므로 2로 나눠줌

reference
https://www.acmicpc.net/problem/13413
*/
