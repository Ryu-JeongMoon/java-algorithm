package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수들의 합
 */
public class _1789 {

	public static void main(String[] args) throws IOException {
		long s = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
		System.out.println(binarySearch(s));
	}

	private static int sequential(long s) {
		int count = 1;
		long number = 1;
		while (s > 2 * number) {
			s -= number++;
			++count;
		}
		return count;
	}

	private static int binarySearch(long s) {
		long min = 1, max = s, mid;
		while (min < max) {
			mid = (min + max + 1) / 2;
			if ((mid * (mid + 1) / 2) <= s) {
				min = mid;
			} else {
				max = mid - 1;
			}
		}
		return (int) min;
	}
}

/*
time complexity
최대 65535번 반복

critical point
입력 범위 최대 값       4,294,967,295
1 ~ 65535까지의 최대 값 4,294,868,992.5
65535(65535 + 65536) / 2

반복 조건은 s >= 2 * number인 경우 number가 중복될 수 있으므로 s > 2 * number 여야 함
s = number + (number + a)인 경우 number + a를 항상 더해야줘야 하므로 count 기본 값을 1로 함

reference
https://www.acmicpc.net/problem/1789
 */