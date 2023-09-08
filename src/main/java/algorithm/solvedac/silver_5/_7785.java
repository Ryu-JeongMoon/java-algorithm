package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 회사에 있는 사람
 */
public class _7785 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<String> employees = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      if (line[1].equals("leave")) {
        employees.remove(line[0]);
      } else {
        employees.add(line[0]);
      }
    }

    StringBuilder result = employees.stream()
      .sorted(Comparator.reverseOrder())
      .collect(StringBuilder::new, (sb, employee) -> sb.append(employee).append("\n"), StringBuilder::append);
    System.out.print(result);
  }
}

/*
time complexity
O(NlogN)

critical point
성능 개선 필요 ?!

reference
https://www.acmicpc.net/problem/7785
*/
