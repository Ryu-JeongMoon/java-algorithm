package algorithm.solvedac.silver_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 패션왕 신해빈
 */
public class _9375 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());

    Map<String, Set<String>> outfitsPerPart = new HashMap<>();
    while (--n >= 0) {
      outfitsPerPart.clear();
      int number = Integer.parseInt(br.readLine());
      for (int i = 0; i < number; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String value = st.nextToken(), key = st.nextToken();
        if (!outfitsPerPart.containsKey(key)) {
          outfitsPerPart.put(key, new HashSet<>());
        }
        outfitsPerPart.get(key).add(value);
      }
      int sum = 1;
      for (Set<String> value : outfitsPerPart.values()) {
        sum *= value.size() + 1;
      }
      bw.write((sum - 1) + "\n");
    }
    bw.flush();
    bw.close();
  }
}

/*
time complexity
O(N)

critical point
1. 조합의 수를 구할 때 부위 별로 입지 않은 경우도 고려 (null 포함)
2. 모든 부위를 입지 않은 경우 고려, 모든 경우의 수에서 -1

reference
https://www.acmicpc.net/problem/9375
*/
