package algorithm.programmers.level1;

public class TheNumberOfPAndY {

    public static void main(String[] args) {

        System.out.println(solution("pPoooyY"));
    }

    static boolean solution(String s) {
        boolean answer = true;

        char[] chars = s.toLowerCase().toCharArray();

        int countOfP = 0;
        int countOfY = 0;

        for (char character : chars) {
            if (character == 'p') {
                countOfP++;
            } else if (character == 'y') {
                countOfY++;
            }
        }

        if (countOfP != countOfY) {
            answer = false;
        }

        return answer;
    }
}
