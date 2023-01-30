package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 방 배정
 */
public class _13300 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[][] gradeSexCount = new int[7][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int sex = Integer.parseInt(st.nextToken());
      int grade = Integer.parseInt(st.nextToken());
      gradeSexCount[grade][sex]++;
    }

    int room = 0;
    for (int[] ints : gradeSexCount) {
      for (int i : ints) {
        if (i != 0) {
          if (i % k == 0) {
            room += (i / k);
          } else {
            room += (i / k) + 1;
          }
        }
      }
    }

    System.out.println(room);
  }
}
