package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오븐 시계
 */
public class _2525 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int currentHour = Integer.parseInt(st.nextToken());
    int currentMinute = Integer.parseInt(st.nextToken());
    int elapsedTime = Integer.parseInt(br.readLine());

    int totalElapsedMinute = currentMinute + elapsedTime;
    int elapseCeilHour = totalElapsedMinute / 60;
    int elapsedMinute = totalElapsedMinute % 60;
    int elapsedHour = (currentHour + elapseCeilHour) % 24;

    System.out.print(elapsedHour + " " + elapsedMinute);
  }
}
