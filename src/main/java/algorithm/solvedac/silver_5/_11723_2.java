package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 집합
 */
public class _11723_2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<Integer> set = new HashSet<>();
    Set<Integer> all = IntStream.rangeClosed(1, 20)
      .collect(HashSet::new, HashSet::add, HashSet::addAll);

    StringBuilder sb = new StringBuilder();
    Map<String, Consumer<Integer>> consumerMap = new HashMap<>();
    consumerMap.put("add", set::add);
    consumerMap.put("remove", set::remove);
    consumerMap.put("check", i -> sb.append(set.contains(i) ? 1 : 0).append("\n"));
    consumerMap.put("toggle", i -> {
      if (set.contains(i)) {
        set.remove(i);
      } else {
        set.add(i);
      }
    });
    consumerMap.put("all", i -> set.addAll(all));
    consumerMap.put("empty", i -> set.clear());

    while (--n >= 0) {
      String[] line = br.readLine().split(" ");
      if (line[0].equals("all") || line[0].equals("empty")) {
        consumerMap.get(line[0]).accept(0);
      } else {
        consumerMap.get(line[0]).accept(Integer.parseInt(line[1]));
      }
    }
    System.out.print(sb);
  }
}

/*
    메모리(kb)	시간(ms)
1 - 15360	      280
2 - 330572	    1532
*/
