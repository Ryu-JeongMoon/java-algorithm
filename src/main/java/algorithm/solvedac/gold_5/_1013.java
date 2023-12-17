package algorithm.solvedac.gold_5;

import java.io.IOException;
import java.util.regex.Pattern;

import algorithm.util.FastIO;

/**
 * Contact
 */
public class _1013 {

  private static final Pattern PATTERN = Pattern.compile("(100+1+|01)+");
  private static final FastIO io = new FastIO();

  public static void main(String[] args) throws IOException {
    int n = io.nextInt();
    for (int i = 0; i < n; i++) {
      io.writeln(PATTERN.matcher(io.readString()).matches() ? "YES" : "NO");
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
pattern matching

reference
https://www.acmicpc.net/problem/1013
*/
