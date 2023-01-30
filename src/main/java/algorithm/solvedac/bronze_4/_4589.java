package algorithm.solvedac.bronze_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Gnome Sequencing
 */
public class _4589 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder("Gnomes:\n");
    while (n-- > 0) {
      String[] s = br.readLine().split(" ");
      int first = Integer.parseInt(s[0]);
      int second = Integer.parseInt(s[1]);
      int third = Integer.parseInt(s[2]);
      if (first > second && second > third || first < second && second < third) {
        sb.append("Ordered\n");
      } else {
        sb.append("Unordered\n");
      }
    }
    System.out.println(sb);
  }
}

/*
3
40 62 77
88 62 77
91 33 18
 */
