package algorithm.programmers.level1;

import java.util.Arrays;

public class RemoveLeastNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
//        int[] arr = {1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        if (arr.length <= 1) {
            return new int[]{-1};
        }

        final int minValue = Arrays.stream(arr.clone())
            .boxed()
            .min(Integer::compareTo)
            .orElseThrow(RuntimeException::new);

        return Arrays.stream(arr)
            .boxed()
            .filter(i -> i != minValue)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

/*
속도 진짜 느리당
 */