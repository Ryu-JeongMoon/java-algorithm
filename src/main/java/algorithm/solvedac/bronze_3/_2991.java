package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사나운 개
 */
public class _2991 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int a = Integer.parseInt(inputs[0]), b = Integer.parseInt(inputs[1]), c = Integer.parseInt(inputs[2]), d = Integer.parseInt(inputs[3]);
    String[] secondInputs = br.readLine().split(" ");

    for (int i = 0; i < 3; i++) {
      int result = 0;
      int time = Integer.parseInt(secondInputs[i]);
      int aRemainder = time % (a + b);
      int cRemainder = time % (c + d);
      if (aRemainder > 0 && aRemainder <= a) {
        result++;
      }
      if (cRemainder > 0 && cRemainder <= c) {
        result++;
      }
      System.out.println(result);
    }
  }
}

/*
time complexity
O(1)

critical point
a분 -> 2, b분 -> 2일 때, p % (a + b)는 0, 1, 2, 3 가능
모든 수는 1보다 크다 했으니 4, 1, 2, 3으로 인식
1, 2일때는 공격 중 3, 4일 때는 휴식 중
if (aRemainder > 0 && aRemainder <= a) 공격 중

reference
https://www.acmicpc.net/problem/2991
 */