package algorithm.util;

import java.io.IOException;

public class SimpleIntReader {

  public static int nextInt() throws IOException {
    int sum = 0;
    while (true) {
      int input = System.in.read();
      if (input == '\n' || input == ' ') {
        return sum;
      } else {
        sum = (sum * 10) + input - '0';
      }
    }
  }

  public static int nextIntWithNegative() throws IOException {
    int sum = 0;
    boolean isNegative = false;
    while (true) {
      int input = System.in.read();
      if (input == '-') {
        isNegative = true;
      } else if (input == '\n' || input == ' ') {
        return isNegative ? -sum : sum;
      } else {
        sum = (sum * 10) + (input - '0');
      }
    }
  }
}
