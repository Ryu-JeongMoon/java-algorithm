package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 지능형 기차
 */
public class _2455 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int sum = 0, max = 0;
    for (int i = 0; i < 3; i++) {
      String[] s = br.readLine().split(" ");
      sum += (Integer.parseInt(s[1]) - Integer.parseInt(s[0]));
      if (max < sum) {
        max = sum;
      }
    }

    System.out.println(max);
  }
}

/*
time complexity
O(1)

critical point
종착역에서 타는 사람은 없다, 네개의 역을 다 입력 받을 필요 없다
 */
