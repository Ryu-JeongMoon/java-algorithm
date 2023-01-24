package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 가장 많은 글자
 */
public class _1371 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] characters = new int[26];
    int max = Integer.MIN_VALUE;
    String line;
    while ((line = br.readLine()) != null && line.length() != 0) {
      for (int i : line.toCharArray()) {
        if (i != 32) {
          ++characters[i - 'a'];
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < characters.length; i++) {
      if (max < characters[i]) {
        max = characters[i];
        sb = new StringBuilder();
        sb.append((char) (i + 'a'));
      } else if (max == characters[i]) {
        sb.append((char) (i + 'a'));
      }
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point
1. while ((line = br.readLine()) != null)
더 이상 입력이 없을 때까지 입력 받기 위한 조건으로 사용
IDE에서 돌릴 때 입력 종료 되지 않음, line.length() != 0 조건 추가 후 한 줄 더 입력 해줘야 함

2. StringBuilder에 char 추가 시 명시적 형변환 필요

reference
https://www.acmicpc.net/problem/1371
 */