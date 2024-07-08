package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 카약
 */
public class _2890 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] numbers = br.readLine().split(" ");
    int r = Integer.parseInt(numbers[0]), c = Integer.parseInt(numbers[1]);
    int[] kayaks = new int[9];
    Pattern numberPattern = Pattern.compile(".*[0-9]+.*");

    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < r; i++) {
      String line = br.readLine();
      if (!numberPattern.matcher(line).matches()) {
        continue;
      }

      char[] chars = line.toCharArray();
      int index = 0;
      for (int j = 0; j < c; j++) {
        if (Character.isDigit(chars[j])) {
          kayaks[chars[j] - '0' - 1] = index;
          if (!indices.contains(index)) {
            indices.add(index);
          }
          break;
        } else if (chars[j] == '.') {
          ++index;
        }
      }
    }

    indices.sort(Comparator.reverseOrder());

    int rank = 1;
    Map<Integer, Integer> ranking = new HashMap<>();
    for (Integer index : indices) {
      ranking.put(index, rank++);
    }

    StringBuilder sb = new StringBuilder();
    for (int kayak : kayaks) {
      sb.append(ranking.get(kayak)).append('\n');
    }

    br.close();
    System.out.print(sb);
  }
}

/*
time complexity
O(NlogN)

critical point
1. 행이 숫자를 포함하지 않는 경우 continue
2. 각 행 별로 숫자가 처음 등장하는 곳 == index, 위치를 찾아 kayak 배열에 기록
3. index 위치에 따른 랭킹을 구하기 위해 indices 리스트에 중복 제외하여 삽입
4. index 숫자가 높을수록 순위가 높기 때문에 indices 역순 정렬
5. 역순 정렬한 indices 순회하며 ranking 해시맵에 랭크 기록
6. 카약의 순서대로 랭크 기록

reference
https://www.acmicpc.net/problem/2890
*/
