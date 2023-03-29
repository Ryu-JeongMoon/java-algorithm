package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 날짜 계산
 */
public class _1476 {

  public static void main(String[] args) throws IOException {
    String[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int e = Integer.parseInt(input[0]), year = Integer.parseInt(input[1]), m = Integer.parseInt(input[2]);
    while (true) {
      int nextE = year % 15 == 0 ? 15 : year % 15;
      int nextM = year % 19 == 0 ? 19 : year % 19;
      if (nextE == e && nextM == m) {
        System.out.println(year);
        return;
      }
      year += 28;
    }
  }
}

/*
time complexity
O(1)

critical point
각자 범위값으로 나눴을 때 0이라면 범위의 최댓값으로 치환
변수 세개 모두 더할 필요 없이 한 변수를 고정 시켜 놓고 나머지 두 변수를 증가시키면서 비교
15, 19, 28 중 28이 가장 크니 28에 해당하는 변수를 고정

reference
https://www.acmicpc.net/problem/1476
 */
