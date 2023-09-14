package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 수학숙제
 */
public class _2870 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<String> numbers = new PriorityQueue<>(Comparator.comparing(String::length).thenComparing(String::compareTo));
    StringBuilder sb = new StringBuilder();
    while (--n >= 0) {
      char[] chars = br.readLine().toCharArray();
      for (int j = 0; j < chars.length; j++) {
        char current = chars[j];
        if (Character.isDigit(current)) {
          sb.append(current);
          if (j == chars.length - 1) {
            add(numbers, sb.toString());
            sb.setLength(0);
          }
        } else if (sb.length() != 0) {
          add(numbers, sb.toString());
          sb.setLength(0);
        }
      }
    }

    sb.setLength(0);
    while (!numbers.isEmpty()) {
      sb.append(numbers.poll()).append("\n");
    }
    System.out.print(sb);
  }

  private static void add(Queue<String> numbers, String key) {
    int index = 0;
    while (key.charAt(index) == '0' && index < key.length() - 1) {
      ++index;
    }
    numbers.offer(key.substring(index));
  }
}

/*
time complexity
O(NlogN)

critical point
문자열 입력 받아 매 문자 마다 순회
현재 문자가 마지막 글자인 경우, 숫자 추가 필요
맨 앞자리 수가 0인 경우 제거 필요

reference
https://www.acmicpc.net/problem/2870
*/
