package algorithm.programmers.level1;

import java.util.regex.Pattern;

public class IdRecommendation {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abcde");
        System.out.println(builder.substring(0, 1));

    }

    public static String solution(String new_id) {
        String answer = "";
        StringBuilder builder = new StringBuilder(new_id);
        Pattern pattern = Pattern.compile("^[a-z0-9-_.]$");

        for (int i = 1; i < builder.length() + 1; i++) {
            if (!pattern.matcher(builder.substring(i - 1, i)).find()) {
                builder.deleteCharAt(i);
            }
        }

        return answer;
    }
}
