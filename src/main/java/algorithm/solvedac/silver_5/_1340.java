package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 연도 진행바
 */
public class _1340 {

	public static void main(String[] args) throws IOException, ParseException {
		String source = new BufferedReader(new InputStreamReader(System.in)).readLine();
		LocalDateTime result = LocalDateTime.parse(source, DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm"));

		double dayTimeInMillis = 24 * 60 * 60 * 1000;
		double currentTimeInMillis =
			result.toInstant(ZoneOffset.UTC).toEpochMilli() - LocalDateTime.of(result.getYear(), 1, 1, 0, 0).toInstant(ZoneOffset.UTC).toEpochMilli();
		double l = isLeapYear(result.getYear())
			? currentTimeInMillis / (dayTimeInMillis * 366)
			: currentTimeInMillis / (dayTimeInMillis * 365);
		System.out.printf("%.9f", l * 100);
	}

	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || ((year & 3) == 0 && (year % 100) != 0);
	}
}

/*
time complexity
O(1)

critical point
1. MMMM dd, yyyy HH:mm 패턴으로 파싱
2. 당해년도 기준 지나간 시간을 구하기 위해 당해년도의 epochMilliseconds - 당해년도 1월 1일 0시 0분 0초 epochMilliseconds
3. 당해년도 기준 지나간 시간 / 윤년인지 판단하여 당해년도 전체 시간의 epochMilliseconds

reference
https://www.acmicpc.net/problem/1340
 */
