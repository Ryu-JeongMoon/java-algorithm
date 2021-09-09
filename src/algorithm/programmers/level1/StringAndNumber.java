package algorithm.programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class StringAndNumber {

    public static void main(String[] args) {
        String str = "one3fiveeight";
        System.out.println(solution(str));
    }

    public static int solution(String str) {
        while (!str.matches("[^a-zA-Z]+")) {
            if (str.contains("zero")) {
                str = str.replace("zero", "0");
            }
            if (str.contains("one")) {
                str = str.replace("one", "1");
            }
            if (str.contains("two")) {
                str = str.replace("two", "2");
            }
            if (str.contains("three")) {
                str = str.replace("three", "3");
            }
            if (str.contains("four")) {
                str = str.replace("four", "4");
            }
            if (str.contains("five")) {
                str = str.replace("five", "5");
            }
            if (str.contains("six")) {
                str = str.replace("six", "6");
            }
            if (str.contains("seven")) {
                str = str.replace("seven", "7");
            }
            if (str.contains("eight")) {
                str = str.replace("eight", "8");
            }
            if (str.contains("nine")) {
                str = str.replace("nine", "9");
            }
        }
        return Integer.parseInt(str);
    }

    // 요건 stream 으로 풀어볼까 해본 것, 나중에 해보자
    private static Map<String, String> getNumberMap() {
        Map<String, String> numberMap = new HashMap<>();
        numberMap.put("zero", "0");
        numberMap.put("one", "1");
        numberMap.put("two", "2");
        numberMap.put("three", "3");
        numberMap.put("four", "4");
        numberMap.put("five", "5");
        numberMap.put("six", "6");
        numberMap.put("seven", "7");
        numberMap.put("eight", "8");
        numberMap.put("nine", "9");
        return numberMap;
    }
}

/**
 * 음 .. 아주 무식하게 풀었구만 단순 반환만 하면 될 때는 replaceAll()을 이용하자
 */