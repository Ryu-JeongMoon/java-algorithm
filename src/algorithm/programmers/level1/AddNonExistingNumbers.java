package algorithm.programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AddNonExistingNumbers {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        return IntStream.rangeClosed(1, 9)
            .filter(i -> Arrays.stream(numbers).filter(n -> n == i).findAny().isEmpty())
            .sum();
    }
}
