package algorithm.programmers.level1;

public class CaesarCipher {

    public static void main(String[] args) {
        System.out.println(solution("z", 1));
    }

    public static String solution(String sentence, int interval) {
        StringBuilder answer = new StringBuilder();
        char[] chars = sentence.toCharArray();

        for (char c : chars) {
            int charNumber = (int) c + interval;
            if (charNumber > 90 && (int) c <= 90) {
                answer.append(Character.toString(charNumber - 26));
            } else if (charNumber > 122 && (int) c <= 122) {
                answer.append(Character.toString(charNumber - 26));
            } else if ((int) c == 32) {
                answer.append(c);
            } else {
                answer.append(Character.toString(charNumber));
            }
        }
        return answer.toString();
    }
}
