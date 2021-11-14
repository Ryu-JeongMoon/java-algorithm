package codetest;

import java.util.Arrays;
import java.util.Collections;

public class Number1 {

    public static void main(String[] args) {

        System.out.println(solution(2613));
    }

    public static int solution(int N) {
        String temp = Integer.toString(N);
        int[] numbers = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++) {
            numbers[i] = temp.charAt(i) - '0';
        }

        Integer[] numbers2 = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(numbers2, Collections.reverseOrder());
        Arrays.sort(numbers);

        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer += (numbers[i] + numbers2[i])*Math.pow(10, numbers.length-i-1);
        }

        return answer;
    }
}
