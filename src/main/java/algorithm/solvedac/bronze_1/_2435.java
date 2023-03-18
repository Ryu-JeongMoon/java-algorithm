package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 기상청 인턴 신현수
 */
public class _2435 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] totalCountAndInterval = br.readLine().split(" ");
    int totalCount = Integer.parseInt(totalCountAndInterval[0]), interval = Integer.parseInt(totalCountAndInterval[1]);

    String[] temperaturesString = br.readLine().split(" ");
    int[] temperatures = new int[totalCount];
    for (int i = 0; i < temperaturesString.length; i++) {
      temperatures[i] = Integer.parseInt(temperaturesString[i]);
    }

    int current = 0;
    for (int i = 0; i < interval; i++) {
      current += temperatures[i];
    }

    int max = current;
    for (int i = 0; i < totalCount - interval; i++) {
      current += temperatures[i + interval] - temperatures[i];
      if (current > max) {
        max = current;
      }
    }
    System.out.println(max);
  }
}

/*
time complexity
O(n)

critical point
매 반복마다 합을 다시 계산하지 않도록 current 변수에 현재 값 저장 후
범위에서 벗어나는 이전 값을 빼고 범위에 새롭게 포함되는 다음 값만 더해줌
반복은 i = totalCount - interval - 1 까지만 실행되므로 OutOfIndex 에러 발생하지 않음

reference
https://www.acmicpc.net/problem/2435
 */
