package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TV 크기
 */
public class _1297 {

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int diagonal = Integer.parseInt(s[0]), heightRate = Integer.parseInt(s[1]), widthRate = Integer.parseInt(s[2]);
    double x = Math.sqrt(Math.pow(diagonal, 2) / (Math.pow(heightRate, 2) + Math.pow(widthRate, 2)));
    int height = (int) (heightRate * x), width = (int) (widthRate * x);
    System.out.println(height + " " + width);
  }
}

/*
time complexity
O(1)

critical point
widthRate * x = 실제 너비
heightRate * x = 실제 높이
x를 구할 때 int 캐스팅 시 소수점 아래로 날라가 실제 길이와 달라질 수 있음을 주의
double 캐스팅하여 heightRate와 곱한 후 int 캐스팅해서 그 수보다 작으면서 가장 큰 정수로 출력해야 한다

reference
https://www.acmicpc.net/problem/1297
 */