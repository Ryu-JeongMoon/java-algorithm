package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 피보나치 함수
 */
public class _1003 {

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] cases = new int[nextInt()];
    int max = 0;
    for (int i = 0; i < cases.length; i++) {
      cases[i] = nextInt();
      max = Math.max(max, cases[i]);
    }

    int[] fibonacci = new int[max + 2];
    fibonacci[0] = 1;
    fibonacci[1] = 0;
    for (int i = 2; i <= max + 1; i++) {
      fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    for (int aCase : cases) {
      bw.write(fibonacci[aCase] + " " + fibonacci[aCase + 1] + "\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
m = max(cases)
O(m)

critical point
fibonacci[0]을 제외, 대각선 방향 동일한 값 패턴
1 0
0 1
1 1
1 2
2 3
3 5
5 8
8 13
...

reference
https://www.acmicpc.net/problem/1003
*/
