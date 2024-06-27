package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 암호 해독
 */
public class _2149 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String key = br.readLine(), encrypted = br.readLine();
    int keyLength = key.length(), n = encrypted.length() / keyLength;
    int[] indices = findIndices(key);

    char[][] array = new char[n][keyLength];
    for (int i = 0; i < keyLength; i++) {
      for (int j = 0; j < n; j++) {
        array[j][indices[i]] = encrypted.charAt(i * n + j);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char[] chars : array) {
      for (int j = 0; j < array[0].length; j++) {
        sb.append(chars[j]);
      }
    }

    br.close();
    System.out.println(sb);
  }

  private static int[] findIndices(String key) {
    int keyLength = key.length();
    char[] source = key.toCharArray(), target = new char[keyLength];
    System.arraycopy(source, 0, target, 0, keyLength);
    Arrays.sort(target);

    boolean[] visited = new boolean[keyLength];
    int[] indices = new int[keyLength];
    for (int i = 0; i < keyLength; i++) {
      char current = target[i];
      for (int j = 0; j < keyLength; j++) {
        if (current == source[j] && !visited[j]) {
          visited[j] = true;
          indices[i] = j;
          break;
        }
      }
    }
    return indices;
  }
}

/*
time complexity
O(N)

critical point
암호화
1. BATBOY -> ABBOTY 순으로 정렬하여 열을 기준으로 자리 변경

sentence = MEETMEBYTHEOLDOAKTREENTH
B	A	T	B	O	Y (기준)
M	E	E	T	M	E
B	Y	T	H	E	O
L	D	O	A	K	T
R	E	E	N	T	H

A B B O T Y (기준)
E	M	T	M	E	E
Y	B	H	E	T	O
D	L	A	K	O	T
E	R	N	T	E	H

2. array[0][0], array[1][0], array[2][0], ... 순으로 이어붙임
EYDE MBLR THAN MEKT ETOE EOTH

복호화
1. 이어붙인 값들을 E -> array[0][0], Y -> array[1][0], D -> array[2][0], ... 순으로 나열
2. ABBOTY를 원래의 값인 BATBOY의 인덱스로 복원
arr1 = [A, B, B, O, T, Y]
arr2 = [B, A, T, B, O, Y]
arr1[0] = arr2[1]
arr1[1] = arr2[0]
arr1[2] = arr2[3]
arr1[3] = arr2[4]
arr1[4] = arr2[2]
arr1[5] = arr2[5]

indices = [1 0 3 4 2 5]
indices 배열을 이용하여 원래 순서대로 출력

reference
https://www.acmicpc.net/problem/2149
*/
