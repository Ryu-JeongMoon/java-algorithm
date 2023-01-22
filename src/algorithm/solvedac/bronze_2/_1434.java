package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 책 정리
 */
public class _1434 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int[] boxes = getArray(br.readLine().split(" "), Integer.parseInt(s[0]));
    int[] books = getArray(br.readLine().split(" "), Integer.parseInt(s[1]));

    int i = 0, j = 0, waste = 0;
    while (i < boxes.length) {
      if (j >= books.length || boxes[i] < books[j]) {
        waste += boxes[i++];
      } else {
        boxes[i] -= books[j++];
      }
    }
    System.out.println(waste);
  }

  private static int[] getArray(String[] strings, int length) {
    int[] boxes = new int[length];
    for (int i = 0; i < length; i++) {
      boxes[i] = Integer.parseInt(strings[i]);
    }
    return boxes;
  }
}

/*
time complexity
O(n)

critical point
1-step. 현재 책이 현재 박스에 들어가지 않으면, 3번으로 간다. 아니면 2번으로 간다.
2-step. 현재 책을 현재 박스에 넣는다. 다음 책을 손에 집고 1번으로 간다.
3-step. 현재 박스를 다른 쪽으로 치운 다음에, 테이프로 못 열게 봉인한다. 다음 박스를 앞으로 가져오고 1번으로 간다.

무조건 1 -> 2 -> 3으로 돌아가는 것으로 문제 잘못 이해함..
박스에 들어가면 2-step, 박스에 안 들어가면 3-step

reference
https://www.acmicpc.net/problem/1434
 */