package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 하얀 칸
 */
public class _1100 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int count = 0;
    for (int i = 0; i < 8; i++) {
      String[] strings = br.readLine().split("");
      for (int j = 0; j < strings.length; j++) {
        if ((i + j) % 2 == 0 && strings[j].equals("F")) {
          ++count;
        }
      }
    }
    System.out.println(count);
  }
}


/*
time complexity
입력값은 고정된 개수 8x8이므로 O(1)

critical point
체스판의 입력 시작점을 0,7로 두고 확인
(x + y) % 2 == 0 검
(x + y) % 2 == 1 흰
 */