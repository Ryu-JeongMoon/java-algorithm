package algorithm.baekjoon.math_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * ACM 호텔
 */
public class _10250 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int x = 0;
    int t = Integer.parseInt(br.readLine());

    while (x++ < t) {
      String[] numbers = br.readLine().split(" ");
      int h = Integer.parseInt(numbers[0]);
      int n = Integer.parseInt(numbers[2]);
      int room = n / h + 1;
      int floor = n % h;
      if (floor == 0) {
        floor = h;
        room--;
      }

      bw.write("" + floor);
      bw.write(room < 10 ? 0 + "" + room : "" + room);
      bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
  }
}

/*
1. 방 호수 표현 주의
n호 -> n < 10 ? 0n호 : n호

2. n이 h로 나눠떨어지는 경우 주의
n = 60, h = 30이라면 330호가 아닌 230호
floor가 0이 되는 경우 room을 1 감소시켜줘야함
 */