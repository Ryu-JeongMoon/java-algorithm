package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 치킨 쿠폰
 */
public class _1673 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] s;
    String line;
    while (!(line = br.readLine()).equals("")) {
      s = line.split(" ");
      int chicken = Integer.parseInt(s[0]), theNumberOfOrderUnit = Integer.parseInt(s[1]), coupon = chicken;
      while (theNumberOfOrderUnit <= coupon) {
        int newChicken = coupon / theNumberOfOrderUnit;
        chicken += newChicken;
        coupon = newChicken + (coupon % theNumberOfOrderUnit);
      }
      sb.append(chicken).append("\n");
    }
    System.out.println(sb);
  }
}

/*
제출       : while ((line = br.readLine()) != null) {
IDE 테스트 : while (!(line = br.readLine()).equals("")) {

time complexity
O(1)

critical point
재귀를 사용해 문제를 풀려 할 때는 엄격한 시간 조건 확인 필요

reference
https://www.acmicpc.net/problem/1673
 */