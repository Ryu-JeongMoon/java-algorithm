package algorithm.programmers.level1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakeWeirdString {

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
        System.out.println(solution("ab  ab  ab ab"));

    }

    static String solution(String str) {
        String answer = "";

        String[] array = str.split("");
        int cnt = 0;

        for (String temp : array) {
            cnt = temp.equals(" ") ? 0 : cnt+1;
            answer += cnt%2==0 ? temp.toLowerCase() : temp.toUpperCase();
        }

        return answer;
    }
}
