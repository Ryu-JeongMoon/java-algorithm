package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 생장점
 */
public class _1703 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String line = br.readLine();
      if (line.equals("0")) {
        break;
      }

      String[] s = line.split(" ");
      int theNumberOfBranches = 1;
      int age = Integer.parseInt(s[0]);
      for (int i = 0; i < age * 2; i += 2) {
        int splittingFactor = Integer.parseInt(s[i + 1]);
        int theNumberOfCutBranches = Integer.parseInt(s[i + 2]);
        theNumberOfBranches *= splittingFactor;
        theNumberOfBranches -= theNumberOfCutBranches;
      }
      sb.append(theNumberOfBranches).append("\n");
    }

    System.out.println(sb);
  }
}

/*
처음에 심는 것은 가지 하나에 잎이 하나 달린 묘목입니다.

1 3 0               -> 3
2 3 0 2 0           -> 6
3 3 0 2 0 2 0       -> 12
3 3 0 2 1 2 3       -> 7
2 4 1 3 4           -> 5
4 5 0 5 1 5 2 5 101 -> 489
0
 */