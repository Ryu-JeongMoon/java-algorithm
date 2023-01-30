package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 나는 요리사다
 */
public class _2953 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    byte index = 0, score = 0;
    for (byte i = 1; i < 6; i++) {
      byte currentScore = 0;
      for (String value : br.readLine().split(" ")) {
        currentScore += Byte.parseByte(value);
      }

      if (currentScore > score) {
        score = currentScore;
        index = i;
      }
    }
    System.out.println(index + " " + score);
  }
}

/*
time complexity
5명의 참가자 고정이므로 O(1)

critical point
5명의 참가자, 최대 5점이므로 byte 사용해 메모리 줄이기

reference
https://www.acmicpc.net/problem/2953
 */