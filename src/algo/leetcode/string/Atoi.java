package algo.leetcode.string;

public class Atoi {

	public static void main(String[] args) {
//		byte one = 1;
//		byte val = (byte) (Byte.MAX_VALUE + one);
//		System.out.println(val);
//		val = (byte) (Byte.MIN_VALUE - one);
//		System.out.println(val);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}

	public int myAtoi(String str) {

		if (str == null || str.trim().length() == 0) {
			return 0;
		}

		str = str.trim();

		int i = 0;
		if (str.charAt(0) == '-' || str.charAt(0) == '+') {

			i++;
		}

		int num = 0;
		while (i < str.length()) {

			int digit = getDigit(str.charAt(i));
			if (digit != -1) {
				int prevNum = num;

				if ((num * 10) < prevNum)
					return 0;
				num = (num * 10) + digit;

			} else {
				break;
			}
			i++;
		}
		return (str.charAt(0) == '-') ? num * -1 : num;

	}

	private int getDigit(char ch) {
		int digit = ch - 48;
		if (digit >= 0 && digit <= 9) {
			return digit;
		}
		return -1;
	}
}
