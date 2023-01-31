package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 세 수
 */
public class _2985 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);
    int biggestIndex = a > b ? a > c ? 0 : 2 : b > c ? 1 : 2;
    switch (biggestIndex) {
      case 0:
        if (b + c == a) {
          System.out.printf("%d=%d+%d", a, b, c);
        } else if (b * c == a) {
          System.out.printf("%d=%d*%d", a, b, c);
        } else if (b - c == a) {
          System.out.printf("%d=%d-%d", a, b, c);
        } else {
          System.out.printf("%d=%d/%d", a, b, c);
        }
        break;
      case 1:
        if (b - c == a) {
          System.out.printf("%d=%d-%d", a, b, c);
        } else {
          System.out.printf("%d=%d/%d", a, b, c);
        }
        break;
      case 2:
        if (a + b == c) {
          System.out.printf("%d+%d=%d", a, b, c);
        } else {
          System.out.printf("%d*%d=%d", a, b, c);
        }
        break;
      default:
        break;
    }
  }
}

/*
time complexity
O(1)

critical point
첫번째 자리가 제일 크다면 4가지 방법이 나올 수 있음
1) first = second * third
2) first = second + third
3) first / second = third
4) first - second = third

reference
https://www.acmicpc.net/problem/2985
 */
