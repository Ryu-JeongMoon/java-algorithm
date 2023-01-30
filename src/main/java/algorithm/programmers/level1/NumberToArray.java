package algorithm.programmers.level1;

import java.util.Arrays;

public class NumberToArray {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(39333939)));
        System.out.println(Arrays.toString(solution2(39333939)));
    }

    public static int[] solution(long number) {
        int[] answer = new int[String.valueOf(number).length()];
        StringBuilder sb = new StringBuilder(String.valueOf(number)).reverse();

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(sb.substring(i, i + 1));
        }
        return answer;
    }

    public static int[] solution2(long number) {
        return new StringBuilder()
            .append(number)
            .reverse()
            .chars()
            .map(Character::getNumericValue)
            .toArray();
    }
}
