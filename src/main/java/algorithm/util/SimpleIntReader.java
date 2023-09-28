package algorithm.util;

import java.io.IOException;

public class SimpleIntReader {

  public static int nextInt() throws IOException {
    int sum = 0, input;
    while ((input = System.in.read()) >= '0') {
      sum = (sum * 10) + input - '0';
    }
    return sum;
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
