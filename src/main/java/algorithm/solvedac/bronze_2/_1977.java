package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 완전제곱수
 */
public class _1977 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int first = Integer.parseInt(br.readLine()), second = Integer.parseInt(br.readLine()), sqrt = (int) Math.sqrt(first);
    int[] arr = new int[(int) Math.sqrt(second) + 1];
    int index = 0;
    while (sqrt * sqrt <= second) {
      if (sqrt * sqrt >= first) {
        arr[index++] = sqrt * sqrt;
      }
      ++sqrt;
    }

    if (arr[0] == 0) {
      System.out.println(-1);
      return;
    }

    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    System.out.println(sum + "\n" + arr[0]);
  }
}

/*
time complexity
최대 10,000 이하의 자연수에 n^2씩 늘어나므로 O(1)

critical point
존재할 수 있는 완전 제곱수는 최대 Math.sqrt(second) + 1개
ex) 100까지의 완전 제곱수 개수는 ? 1 4 9 ... 100 -> 10개
완전제곱수를 위한 배열을 가능한 최대 사이즈로 잡음

reference
https://www.acmicpc.net/problem/1977
 */