package algorithm.programmers.level1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class Year2016 {

    public static void main(String[] args) {
        Map<String, String> dayOfWeekMap = Map.of("0", "FRI", "1", "SAT", "2", "SUN",
            "3", "MON", "4", "TUE", "5", "WED", "6", "THU");

        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        Map<Long, String> dayOfWeekMap = Map.of(0L, "FRI", 1L, "SAT", 2L, "SUN",
            3L, "MON", 4L, "TUE", 5L, "WED", 6L, "THU");

        long between = ChronoUnit.DAYS.between(LocalDate.of(2016, 1, 1), LocalDate.of(2016, a, b));

        return dayOfWeekMap.get(between % 7);
    }
}
