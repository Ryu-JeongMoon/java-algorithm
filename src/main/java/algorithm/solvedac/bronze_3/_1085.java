package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 직사각형에서 탈출
 */
public class _1085 {

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());

    // System.out.println(sol1(x, y, w, h));
    System.out.println(sol2(x, y, w, h));
  }

  private static int sol1(int x, int y, int w, int h) {
    return Math.min(Math.min(x, w - x), Math.min(y, h - y));
  }

  private static int sol2(int x, int y, int w, int h) {
    int[] arr = { x, y, w - x, h - y };
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (min > arr[i]) {
        min = arr[i];
      }
    }
    return min;
  }
}

/*
time complexity
O(1)

critical point
직사각형의 경계까지 가는 거리 중 가장 짧은 거리를 출력한다.
0 <= x <= w, 0 <= y <= h
x를 0, w와의 거리와 비교하여 짧은 값
y를 0, h와의 거리와 비교하여 짧은 값
둘 중 작은 값이 답

6 2 10 3 -> 1
653 375 1000 1000 -> 347
161 181 762 375 -> 161
 */
