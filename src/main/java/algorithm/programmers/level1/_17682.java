package algorithm.programmers.level1;

import java.util.Arrays;

/**
 * [1차] 다트 게임
 */
public class _17682 {

  public static void main(String[] args) {
    _17682 instance = new _17682();
    System.out.println(instance.solution("1S2D*3T"));
    System.out.println(instance.solution("1D2S#10S"));
    System.out.println(instance.solution("1D2S0T"));
    System.out.println(instance.solution("1S*2T*3S"));
    System.out.println(instance.solution("1D#2S*3S"));
    System.out.println(instance.solution("1T2D3D#"));
    System.out.println(instance.solution("1D2S3T*"));
  }

  private static int[] SCORES;

  public int solution(String dartResult) {
    String[] numbers = dartResult.split("\\D+");
    SCORES = new int[numbers.length];
    for (int i = 0; i < SCORES.length; i++) {
      SCORES[i] = Integer.parseInt(numbers[i]);
    }

    String[] bonusesAndOptions = dartResult.split("\\d+");
    for (int i = 0; i < SCORES.length; i++) {
      char[] chars = bonusesAndOptions[i + 1].toCharArray();
      for (char c : chars) {
        if (Character.isLetter(c)) {
          handleBonus(c, i);
        } else {
          handleOption(c, i);
        }
      }
    }

    return Arrays.stream(SCORES).sum();
  }

  private void handleBonus(char currentChar, int i) {
    if (currentChar == 'D') {
      SCORES[i] = (int) Math.pow(SCORES[i], 2);
    } else if (currentChar == 'T') {
      SCORES[i] = (int) Math.pow(SCORES[i], 3);
    }
  }

  private void handleOption(char currentChar, int i) {
    if (currentChar == '*') {
      SCORES[i] *= 2;
      if (i > 0) {
        SCORES[i - 1] *= 2;
      }
    } else if (currentChar == '#') {
      SCORES[i] *= -1;
    }
  }
}

/*
time complexity
O(N)

critical point
입력값을 어떻게 자를 것인가

reference
https://school.programmers.co.kr/learn/courses/30/lessons/17682
*/
