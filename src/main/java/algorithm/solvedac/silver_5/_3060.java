package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 욕심쟁이 돼지
 */
public class _3060 {

  public static void main(String[] args) throws IOException {
    int t = nextInt(), theNumberOfPigs = 6;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int feed = nextInt(), sum = 0;
      for (int j = 0; j < theNumberOfPigs; j++) {
        sum += nextInt();
      }

      int day = 1;
      while (feed >= sum) {
        sum *= 4;
        ++day;
      }
      sb.append(day).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(n)

critical point
양옆과 반대편 돼지의 사료 양만큼 증가로 인한 전체 사료양 증가율 규칙 찾기

reference
https://www.acmicpc.net/problem/3060
*/
