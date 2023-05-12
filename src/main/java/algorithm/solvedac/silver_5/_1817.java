package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 짐 챙기는 숌
 */
public class _1817 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    if (Integer.parseInt(s[0]) == 0) {
      System.out.println(0);
      return;
    }

    int sum = 0, theNumberOfBox = 1;
    String[] weights = br.readLine().split(" ");
    for (String weightString : weights) {
      int weight = Integer.parseInt(weightString);
      if (sum + weight > Integer.parseInt(s[1])) {
        ++theNumberOfBox;
        sum = weight;
      } else {
        sum += weight;
      }
    }
    System.out.println(theNumberOfBox);
  }
}

/*
time complexity
O(n)

critical point
입력 특이값을 고려할 것 -> 0 or 범위 끝 값 등
박스 개수를 증가시킨 후 무게 총합은 0이 아닌 현재 무게로 초기화해야 함
아래 입력 예시를 고려해보면 이해가 쉬움
5 100
51 51 51 51 51

1. 박스를 새로 갈아 끼우고 -> ++theNumberOfBox;
2. 현재 책을 집어넣는다    -> sum = weight;

reference
https://www.acmicpc.net/problem/1817
 */