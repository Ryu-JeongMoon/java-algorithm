package algorithm.programmers.level1;

public class CollatzConjecture {

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    public static int solution(long num) {
        int count = 0;

        while (num != 1) {
            if (count == 500) {
                return -1;
            } else if (num % 2 == 0) {
                num /= 2;
                count++;
            } else {
                num = num * 3 + 1;
                count++;
            }
        }

        return count;
    }
}
