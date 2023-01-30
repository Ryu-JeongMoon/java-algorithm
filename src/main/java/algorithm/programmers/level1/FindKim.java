package algorithm.programmers.level1;

import java.util.HashMap;
import java.util.stream.IntStream;

public class FindKim {

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        System.out.println(solution(seoul));
        System.out.println(solution2(seoul));
    }

    public static String solution(String[] seoul) {
        HashMap<String, Integer> findKimMap = new HashMap<>();
        IntStream.range(0, seoul.length)
            .forEach(i -> findKimMap.put(seoul[i], i));
        return String.format("김서방은 %d에 있다", findKimMap.get("Kim"));
    }

    public static String solution2(String[] seoul) {
        int positionOfKim = IntStream.range(0, seoul.length)
            .filter(i -> seoul[i].equals("Kim"))
            .findAny()
            .getAsInt();
        return String.format("김서방은 %d에 있다", positionOfKim);
    }
}

/**
 * 우헤헤 스트림으로 풀었당
 */