package algorithm.programmers.level1;

public class BasicStringHandling {
    public static void main(String[] args) {
        //        System.out.println(solution("1234"));

        System.out.println(solution("120321"));
    }

    public static boolean solution(String s) {
        try {
            Integer.parseInt(s);
            return s.length() == 4 || s.length() == 6;
        } catch (Exception e) {
            return false;
        }
    }
}
