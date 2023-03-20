package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 대표값
 */
public class _2592 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    byte[] numbers = new byte[101];
    String line;
    int totalCount = 0;
    while ((line = br.readLine()) != null) {
      ++numbers[Integer.parseInt(line) / 10];
      ++totalCount;
    }
    int average = 0, count = 0, frequency = 0, frequentValue = 0;
    for (byte i = 1; i < numbers.length; i++) {
      if (totalCount == count) {
        break;
      } else if (numbers[i] != 0) {
        count += numbers[i];
        average += (i * numbers[i]);
        if (frequency < numbers[i]) {
          frequency = numbers[i];
          frequentValue = i;
        }
      }
    }
    System.out.println(average * 10 / count);
    System.out.println(frequentValue * 10);
  }
}

/*
time complexity
O(N)

critical point
1. 주어지는 자연수는 1,000 보다 작은 10의 배수 -> int[101]
2. 입력 받을 때부터 totalCount 세어 찔끔 최적화
3. 최빈값 갱신

reference
https://www.acmicpc.net/problem/2592
 */