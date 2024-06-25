package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 파일 구별하기
 */
public class _2371 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()), max = Integer.MIN_VALUE, count = 0;
    ArrayList<String[]> lines = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      lines.add(line);
      max = Math.max(max, line.length);
    }

    Set<String> chars = new HashSet<>();
    for (int i = 0; i < max; i++) {
      int countOfChars = 0;
      for (int j = 0; j < n; j++) {
        String[] current = lines.get(j);
        if (current.length > i) {
          ++countOfChars;
          chars.add(current[i]);
        }
      }

      if (chars.size() == countOfChars) {
        break;
      }

      ++count;
      chars.clear();
    }

    System.out.println(count + 1);
  }
}

/*
time complexity
O(NM)

critical point
같은 인덱스에 동일한 문자가 없다면 구별 가능

reference
https://www.acmicpc.net/problem/2371
*/
