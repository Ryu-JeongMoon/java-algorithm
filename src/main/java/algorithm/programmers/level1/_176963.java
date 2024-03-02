package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 추억 점수
 */
public class _176963 {

  public static void main(String[] args) {
    _176963 instance = new _176963();
    System.out.println(Arrays.toString(instance.solution(
      new String[] { "may", "kein", "kain", "radi" },
      new int[] { 5, 10, 1, 3 },
      new String[][] { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" }, { "kon", "kain", "may", "coni" } })));
    System.out.println(Arrays.toString(instance.solution(
      new String[] { "kali", "mari", "don" },
      new int[] { 11, 1, 55 },
      new String[][] { { "kali", "mari", "don" }, { "pony", "tom", "teddy" }, { "con", "mona", "don" } })));
    System.out.println(Arrays.toString(instance.solution(
      new String[] { "may", "kein", "kain", "radi" },
      new int[] { 5, 10, 1, 3 },
      new String[][] { { "may" }, { "kein", "deny", "may" }, { "kon", "coni" } })));
  }

  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    Map<String, Integer> nameAndYearning = new HashMap<>();
    for (int i = 0; i < name.length; i++) {
      nameAndYearning.put(name[i], yearning[i]);
    }

    int[] answer = new int[photo.length];
    for (int i = 0; i < photo.length; i++) {
      for (int j = 0; j < photo[i].length; j++) {
        answer[i] += nameAndYearning.getOrDefault(photo[i][j], 0);
      }
    }
    return answer;
  }
}

/*
time complexity
l = photo[i].length
O(N * l)

critical point

reference
https://school.programmers.co.kr/learn/courses/30/lessons/176963
*/
