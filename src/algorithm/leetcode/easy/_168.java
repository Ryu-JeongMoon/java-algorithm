package algorithm.leetcode.easy;

/**
 * 168. Excel Sheet Column Title
 */
public class _168 {

	private static final int ALPHABET_SIZE = 26;
	private static final String[] ALPHABETS = new String[] {
		"NOTHING", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	public static void main(String[] args) {
		System.out.println("result = " + new _168().convertToTitle(701));
	}

	public String convertToTitle(int columnNumber) {
		if (columnNumber < ALPHABET_SIZE + 1) {
			return ALPHABETS[columnNumber];
		}

		StringBuilder result = new StringBuilder();
		while (columnNumber > ALPHABET_SIZE) {
			int remain = columnNumber % ALPHABET_SIZE;
			if (remain == 0) {
				remain = ALPHABET_SIZE;
				columnNumber -= ALPHABET_SIZE;
			}

			result.append(ALPHABETS[remain]);
			columnNumber /= ALPHABET_SIZE;
		}

		return result.append(ALPHABETS[columnNumber]).reverse().toString();
	}
}

/*
52 -> AZ
701 -> ZY

0이 없는 26진법?!
0이 없음을 이용하는 풀이도 존재
 */