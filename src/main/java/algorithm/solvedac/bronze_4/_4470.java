package algorithm.solvedac.bronze_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 줄번호
 */
public class _4470 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      bw.write(i + 1 + ". " + br.readLine() + "\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(n)

critical point

reference
https://www.acmicpc.net/problem/4470
*/
