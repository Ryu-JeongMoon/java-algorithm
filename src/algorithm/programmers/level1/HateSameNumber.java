package algorithm.programmers.level1;

import java.util.LinkedList;

public class HateSameNumber {
    public static void main(String[] args) {
    }

    public static Integer[] solution(int[] arr) {
        LinkedList<Integer> answer = new LinkedList<>();
        answer.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1])
                continue;
            answer.add(arr[i]);
        }

        return answer.toArray(new Integer[0]);
    }
}

/**
 * 요상허게 풀긴했네
 */