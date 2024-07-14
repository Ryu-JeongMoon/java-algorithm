package algorithm.solvedac.bronze_1;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 머신 코드
 */
public class _2929 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    String machineCode = io.readLine();
    int count = 0, temp = 0;
    for (int i = 0; i < machineCode.length(); i++) {
      if (Character.isUpperCase(machineCode.charAt(i))) {
        if (temp % 4 != 0) {
          count += (4 - temp % 4);
        }
        temp = 1;
      } else {
        ++temp;
      }
    }
    io.writelnInt(count);
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
현재 문자가 대문자인 경우
4의 배수가 되기 위해 부족한 바이트 수만큼 count 증가

reference
https://www.acmicpc.net/problem/2929
*/
