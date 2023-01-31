package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class GiveUpMath {

  public static void main(String[] args) {

    int[] answers = { 1, 2, 3, 4, 5 };
    System.out.println(Arrays.toString(solution(answers)));

    TreeSet<Integer> integers = new TreeSet<>();
    integers.add(1);
    integers.add(99);
    integers.add(3);
    integers.add(3);
    integers.add(3);
    integers.add(83);
    integers.add(5);

    System.out.println("integers = " + integers);
  }

  public static int[] solution(int[] answers) {

    int[] studentA = { 1, 2, 3, 4, 5 };
    int[] studentB = { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] studentC = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    int resultOfA = 0, resultOfB = 0, resultOfC = 0;

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == studentA[i % 5]) {
        resultOfA++;
      }
      if (answers[i] == studentB[i % 8]) {
        resultOfB++;
      }
      if (answers[i] == studentC[i % 10]) {
        resultOfC++;
      }
    }

    List<Integer> scorers = new ArrayList<>();

    TreeSet<Integer> integers = new TreeSet<>(List.of(resultOfA, resultOfB, resultOfC));
    Integer maxScore = integers.pollLast();
    if (resultOfA == maxScore) {
      scorers.add(1);
    }
    if (resultOfB == maxScore) {
      scorers.add(2);
    }
    if (resultOfC == maxScore) {
      scorers.add(3);
    }

    int[] ints = new int[scorers.size()];
    for (int i = 0; i < scorers.size(); i++) {
      ints[i] = scorers.get(i);
    }
    return ints;
  }
}

/*
가독성을 위해서 반환해주는 부분에서 stream 돌려서 반환했더니 속도가 많이 느려진다
습관적으로 스트림 쓰고 있는데 성능을 위해서 조금 더 고민해보자, 대신 가독성 측면에서는 스트림이 훨씬 낫다
scorers.stream().mapToInt(Integer::intValue).toArray();
 */
