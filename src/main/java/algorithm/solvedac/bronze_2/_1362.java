package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 펫
 */
public class _1362 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int o = Integer.MAX_VALUE, w = Integer.MAX_VALUE, index = 1;
    String happy = ":-)", sad = ":-(", dead = "RIP", line;
    while (!(line = br.readLine()).equals("0 0")) {
      String[] input = line.split(" ");
      String command = input[0], value = input[1];
      if (w <= 0 && (command.equals("E") || command.equals("F"))) {
        continue;
      }
      switch (command) {
        case "E":
          w -= Integer.parseInt(value);
          break;
        case "F":
          w += Integer.parseInt(value);
          break;
        case "#":
          if (w > o / 2 && w < o * 2) {
            bw.write(index++ + " " + happy + "\n");
          } else if (w <= 0) {
            bw.write(index++ + " " + dead + "\n");
          } else {
            bw.write(index++ + " " + sad + "\n");
          }
          break;
        default:
          o = Integer.parseInt(command);
          w = Integer.parseInt(value);
          break;
      }
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point
1. 펫이 이미 죽은 경우, E / F는 무시할 수 있도록 처리
2. 출력 부분을 하나의 시나리오 끝으로 모음
3. E, F, #이 아닌 경우 새로운 체중의 입력 처리

reference
https://www.acmicpc.net/problem/1362
 */
