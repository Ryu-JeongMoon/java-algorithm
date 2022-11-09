package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 핸드폰 요금
 */
public class _1267 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String[] s = br.readLine().split(" ");
    int[] calls = new int[s.length];
    for (int i = 0; i < s.length; i++) {
      calls[i] = Integer.parseInt(s[i]);
    }

    int sumY = 0, sumM = 0;
    int unitY = 10, unitM = 15;
    for (int call : calls) {
      if ((call / 30) == 0 && call % 30 != 0) {
        sumY += unitY;
      } else {
        sumY += (call / 30) * unitY + unitY;
      }

      if ((call / 60) == 0 && call % 60 != 0) {
        sumM += unitM;
      } else {
        sumM += (call / 60) * unitM + unitM;
      }
    }

    if (sumY < sumM) {
      System.out.println("Y " + sumY);
    } else if (sumY > sumM) {
      System.out.println("M " + sumM);
    } else {
      System.out.println("Y M " + sumY);
    }
  }
}

/*
time complexity
입력값 마다 for-loop 돌려야 하므로 O(n)

critical point
단위 시간이 1 ~ 30초가 아닌 1 ~ 29초까지이다
통화 시간이 0초가 아니며 단위 시간으로 나눠지는 경우엔 단위 요금을 한번 더 추가해야 함
((통화 시간 / 단위 시간) + 1) * 단위 요금으로 계산해야 함

edge-case
2
60 65
Y M 60
 */
