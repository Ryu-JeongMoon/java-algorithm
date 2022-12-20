package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 저항
 */
public class _1076 {

  // new HashMap<String, Integer> Generics 없으면 jdk 1.8에서 컴파일 에러
  private static final Map<String, Integer> COLORS = new HashMap<String, Integer>() {
    {
      put("black", 0);
      put("brown", 1);
      put("red", 2);
      put("orange", 3);
      put("yellow", 4);
      put("green", 5);
      put("blue", 6);
      put("violet", 7);
      put("grey", 8);
      put("white", 9);
    }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String first = br.readLine();
    String second = br.readLine();
    String third = br.readLine();
    long result = (COLORS.get(first) * 10 + COLORS.get(second)) * (long) Math.pow(10, COLORS.get(third));
    System.out.println(result);
  }
}

/*
time complexity
입력값이 정해져있으므로 O(1)

critical point
white, white, white 경우 99 * 10^9 -> int 범위 초과

reference
https://www.acmicpc.net/problem/1076
 */