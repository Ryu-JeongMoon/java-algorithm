package algorithm.solvedac.bronze_2;

import java.io.IOException;

/**
 * Dangerous Dive
 */
public class _13627 {

  public static void main(String[] args) throws IOException {
    int volunteers = nextInt(), survivors = nextInt();
    int theNumberOfVictim = volunteers - survivors;
    if (theNumberOfVictim == 0) {
      System.out.println("*");
      return;
    }

    int[] survived = new int[volunteers];
    for (int i = 0; i < survivors; i++) {
      survived[nextInt() - 1] = 1;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < survived.length; i++) {
      if (survived[i] == 0) {
        sb.append(i + 1).append(" ");
      }
    }
    System.out.println(sb);
  }

  private static int nextInt() throws IOException {
    int sum = 0, input;
    while ((input = System.in.read()) >= '0') {
      sum = (sum * 10) + input - '0';
    }
    return sum;
  }
}

/*
time complexity

critical point

reference
https://www.acmicpc.net/problem/13627
*/
