package algorithm.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class TheNumberOfAliquot {

    public static void main(String[] args) {
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int answer = 0;
        Map<Integer, Integer> answerMap = new HashMap<>();
        for (int i = left; i <= right ; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0)
                    count++;
            }
            if (count % 2 == 0)
                answerMap.put(i, i);
            else
                answerMap.put(i, -i);
        }

        for (Integer value : answerMap.values()) {
            answer += value;
        }
        return answer;
    }
}
