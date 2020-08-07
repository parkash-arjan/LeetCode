package algo.leetcode.string;

public class Atoi {

	public static void main(String[] args) {
		Atoi atoi = new Atoi();
		System.out.println(atoi.myAtoi("-42"));
		// 2147483647 MAX
		// -2147483648 MIN

	}

	public int myAtoi(String str) {

		if (str == null || str.trim().length() == 0) {
			return 0;
		}

		str = str.trim();

		int sign = 1;
		int divideFactor = (Integer.MAX_VALUE / 10) * sign;
		int remainder = (Integer.MAX_VALUE % 10) * sign;

		int i = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			divideFactor = (Integer.MIN_VALUE / 10) * sign;
			remainder = (Integer.MIN_VALUE % 10) * sign;
			i++;
		}
		if (str.charAt(0) == '+') {
			i++;
		}

		int num = 0;
		while (i < str.length()) {

			int digit = getDigit(str.charAt(i));
			if (digit == -1) {
				break;
			}

			if (num < divideFactor)
				num = (num * 10) + digit;
			else if (num == divideFactor && digit <= remainder)
				num = (num * 10) + digit;
			else
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			i++;
		}
		return num * sign;

	}

	private int getDigit(char ch) {
		int digit = ch - 48;
		if (digit >= 0 && digit <= 9) {
			return digit;
		}
		return -1;
	}
}
