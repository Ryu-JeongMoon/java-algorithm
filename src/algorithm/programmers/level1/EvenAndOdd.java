package algorithm.programmers.level1;

public class EvenAndOdd {

    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
