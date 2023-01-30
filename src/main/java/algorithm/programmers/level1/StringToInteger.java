package algorithm.programmers.level1;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(solution("1234"));
    }

    public static int solution(String s) {
        int answer = 0;

        if (s.charAt(0) == '+')
            answer = Integer.parseInt(s.substring(1));
        else if (s.charAt(0) == '-')
            answer = -Integer.parseInt(s.substring(1));
        else
            answer = Integer.parseInt(s);
        return answer;
    }
}
