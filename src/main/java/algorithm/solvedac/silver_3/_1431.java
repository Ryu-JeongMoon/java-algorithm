package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 시리얼 번호
 */
public class _1431 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] serialNumbers = new String[n];
    for (int i = 0; i < n; i++) {
      serialNumbers[i] = br.readLine();
    }

    Comparator<String> comparator = Comparator
      .comparingInt(String::length)
      .thenComparingInt(_1431::getSumOfCiphers)
      .thenComparing(Comparator.naturalOrder());
    Arrays.sort(serialNumbers, comparator);

    StringBuilder sb = new StringBuilder();
    for (String serialNumber : serialNumbers) {
      sb.append(serialNumber).append("\n");
    }
    System.out.print(sb);
  }

  private static int getSumOfCiphers(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        sum += (s.charAt(i) - '0');
      }
    }
    return sum;
  }
}

/*
time complexity
O(NlogN)

critical point
1. 길이순
2. 모든 자리 수의 합
3. 사전순

reference
https://www.acmicpc.net/problem/1431
 */