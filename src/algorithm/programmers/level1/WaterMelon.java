package algorithm.programmers.level1;

public class WaterMelon {

    public static void main(String[] args) {

    }

    public static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                sb.append("수");
            }
            sb.append("박");
        }

        return sb.toString();
    }
}

/**
 * 수박수박수
 */