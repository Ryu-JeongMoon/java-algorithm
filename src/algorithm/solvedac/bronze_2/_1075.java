package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 나누기
 */
public class _1075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine()), f = Long.parseLong(br.readLine());
		long result = getMinimum(n % 100 + (f - n % f), f);
		result = result == 0 ? 0 : (result + f) % 100;
		System.out.printf("%02d", result);
	}

	private static long getMinimum(long result, long f) {
		return result <= 0 ? result : getMinimum(result - f, f);
	}
}

/*
time complexity
O(1)

critical point
n의 십의 자리 수 까지만 구한 후 (f - n % f)를 더하면 f로 나눠지는 수 중 십의 자리 수만 구한 것!
이후엔 꼬리 재귀 활용하여 0보다 크거나 같은 최솟값을 구하는 과정, 이 과정은 상수 시간

reference
https://www.acmicpc.net/problem/1075
 */
