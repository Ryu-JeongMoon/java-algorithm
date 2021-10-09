package algorithm.programmers.level1;

import java.util.Arrays;

public class GetAverage {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).sum() / (double) arr.length;
    }
}
