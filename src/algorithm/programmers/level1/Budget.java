package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Budget {

    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < d.length; i++) {
            integers.add(d[i]);
        }

        integers.sort(Comparator.naturalOrder());

        for (Integer integer : integers) {
            if (integer + sum <= budget) {
                sum += integer;
                answer++;
            }
        }

        return answer;
    }

    public static int solution2(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);
        for (int i : d) {
            if (i+sum <= budget) {
                sum += i;
                answer++;
            }
        }

        return answer;
    }
}