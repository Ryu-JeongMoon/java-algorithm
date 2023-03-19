package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분해합
 */
public class _2231 {

	public static void main(String[] args) throws IOException {
		String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
		int m = Integer.parseInt(input), constructor = 0, start = Math.max(1, m - input.length() * 9);
		for (int i = start; i < m; i++) {
			int value = i, sum = i;
			while (value > 0) {
				sum += value % 10;
				value /= 10;
			}

			if (sum == m) {
				constructor = i;
				break;
			}
		}
		System.out.println(constructor);
	}
}

/*
time complexity
O(N)

critical point
최소로 작은 경우, N - (N의 자릿수 * 9) 부터 시작할 수 있음

reference
https://www.acmicpc.net/problem/1427
 */