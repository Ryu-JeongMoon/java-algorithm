package algorithm.programmers.level1;

public class DiscriminateSquare {

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution(121));
    }

    public static long solution(long n) {
        double squareRoot = Math.sqrt(n);
        long answer = Long.valueOf((long) Math.sqrt(n));

        if (squareRoot > answer) {
            answer = -1;
        } else {
            answer = (answer+1)*(answer+1);
        }
        return answer;
    }
}
