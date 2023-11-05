package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 주몽
 */
public class _1940 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt(), result = 0;
    Set<Integer> numbers = new HashSet<>(n);
    for (int i = 0; i < n; i++) {
      int current = nextInt();
      if (numbers.contains(m - current)) {
        ++result;
        numbers.remove(m - current);
      } else {
        numbers.add(current);
      }
    }
    System.out.println(result);
  }
}

/*
time complexity
O(N)

critical point
모두 삽입 후 체크 x, 삽입 하며 체크 o

reference
https://www.acmicpc.net/problem/1940
*/
