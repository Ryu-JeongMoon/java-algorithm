package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 노래 악보
 */
public class _1392 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]), index = 0;
    int[] music = new int[n * 100];
    for (int i = 0; i < n; i++) {
      int timePerMusic = Integer.parseInt(br.readLine());
      for (int j = index; j < index + timePerMusic; j++) {
        music[j] = i + 1;
      }
      index += timePerMusic;
    }
    for (int i = 0; i < q; i++) {
      int time = Integer.parseInt(br.readLine());
      bw.write(music[time] + "\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point
노래를 부른 범위 != 몇초에 몇번 악보를 부르고 있는지
2초 불렀다 -> 0, 1    (0 ~ 1.9999...)
3초 불렀다 -> 2, 3, 4 (2 ~ 4.9999...)
1초 불렀다 -> 5       (5 ~ 5.9999...)

reference
https://www.acmicpc.net/problem/1392
 */