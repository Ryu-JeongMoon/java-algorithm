package algorithm.programmers.level1;

public class DotProduct {
    public static void main(String[] args) {
        int[] a = { -1, 0, 1 };
        int[] b = { 1, 0, -1 };
        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
