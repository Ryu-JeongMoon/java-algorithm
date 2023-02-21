package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 일곱 난쟁이
 */
public class _2309 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dwarf = new int[9];
    int total = 0;
    for (int i = 0; i < 9; i++) {
      dwarf[i] = Integer.parseInt(br.readLine());
      total += dwarf[i];
    }
    Arrays.sort(dwarf);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      for (int j = i + 1; j < 9; j++) {
        if (total - dwarf[i] - dwarf[j] == 100) {
          for (int d : dwarf) {
            if (d == dwarf[i] || d == dwarf[j]) {
              continue;
            }
            sb.append(d).append("\n");
          }
          System.out.println(sb);
          return;
        }
      }
    }
  }
}

/*
time complexity
어떤 경우라도 9c7 -> 36번, 모든 값 출력 9번 최대 45번 반복 O(1)

critical point
일곱 난쟁이의 키의 합 100
정답이 되는 경우가 여러 개라도 한번만 출력

reference
https://www.acmicpc.net/problem/2309
 */
