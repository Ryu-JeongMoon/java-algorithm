package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 저작권
 */
public class _2914 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    System.out.println(Integer.parseInt(s[0]) * (Integer.parseInt(s[1]) - 1) + 1);
  }
}

/*
time complexity
O(1)

critical point
평균값은 항상 올림을 해서 정수로 만들어야 함
곡수 * (평균값 - 1) + 1 = 올렸을 때 평균값이 나오는 가장 작은 수

reference
https://www.acmicpc.net/problem/2914
 */