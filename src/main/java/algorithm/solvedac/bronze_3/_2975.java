package algorithm.solvedac.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Transactions
 */
public class _2975 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String line = br.readLine();
			if (line.equals("0 W 0")) {
				break;
			}

			String[] s = line.split(" ");
			int balance = Integer.parseInt(s[0]);
			int amount = Integer.parseInt(s[2]);

			switch (s[1]) {
				case "W":
					balance -= amount;
					break;
				case "D":
					balance += amount;
					break;
				default:
					break;
			}

			if (balance < -200) {
				sb.append("Not allowed").append("\n");
			} else {
				sb.append(balance).append("\n");
			}
		}
		System.out.print(sb);
	}
}

/*
time complexity
O(n)

critical point
우왕 쉽당

reference
https://www.acmicpc.net/problem/2975
 */
