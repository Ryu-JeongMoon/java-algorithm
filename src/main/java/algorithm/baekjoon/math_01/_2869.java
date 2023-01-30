package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 달팽이는 올라가고 싶다
 */
public class _2869 {

  public static void main(String[] args) throws IOException {
    String[] numbers = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int a = Integer.parseInt(numbers[0]);
    int b = Integer.parseInt(numbers[1]);
    int v = Integer.parseInt(numbers[2]);

    if (a >= v) {
      System.out.println(1);
      return;
    }

    int days = (v - a) / (a - b) + 1;
    if ((v - a) % (a - b) != 0)
      days++;

    System.out.println(days);
  }
}

/*
v = n * (a - b) + a 는 +a 때문에 1일 추가해줘야함둥
 */