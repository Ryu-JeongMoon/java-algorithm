package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피시방 알바
 */
public class _1453 {

  public static void main(String[] args) throws IOException {
    boolean[] seats = new boolean[100];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int theNumberOfPeople = Integer.parseInt(br.readLine()), count = 0;
    for (String s : br.readLine().split(" ")) {
      if (seats[Integer.parseInt(s) - 1]) {
        ++count;
      } else {
        seats[Integer.parseInt(s) - 1] = true;
      }
    }
    System.out.println(count);
  }
}

/*
time complexity
O(n)

critical point
index 주의, -1 하거나 new boolean[101] 하거나

reference
https://www.acmicpc.net/problem/1453
 */
