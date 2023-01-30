package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 애너그램 만들기
 */
public class _1919 {

  private static final int NUMBER_OF_ALPHABET = 26;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] alphabets = new int[2][26];
    char[] words1 = br.readLine().toCharArray();
    for (char c : words1) {
      alphabets[0][c - 'a'] += 1;
    }

    char[] words2 = br.readLine().toCharArray();
    for (char c : words2) {
      alphabets[1][c - 'a'] += 1;
    }

    int numberOfCharactersToBeDelete = 0;
    for (int i = 0; i < NUMBER_OF_ALPHABET; i++) {
      numberOfCharactersToBeDelete += Math.abs(alphabets[0][i] - alphabets[1][i]);
    }

    System.out.print(numberOfCharactersToBeDelete);
  }
}
