package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 꼬리를 무는 숫자 나열
 */
public class _1598 {

  public static void main(String[] args) throws IOException {
    String[] numbers = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int a = Integer.parseInt(numbers[0]);
    int b = Integer.parseInt(numbers[1]);

    int x1 = (a - 1) / 4, x2 = (b - 1) / 4;
    int y1 = -((a - 1) % 4), y2 = -((b - 1) % 4);

    System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
  }
}
