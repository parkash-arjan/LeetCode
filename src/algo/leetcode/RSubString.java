package algo.leetcode;

public class RSubString {
	public static void main(String[] args) {

//		[0,1] means shift to left by 1. "abc" -> "bca"
//		[1,2] means shift to right by 2. "bca" -> "cab"
		String str = new RSubString().stringShift("abc", new int[][] { { 0, 1 }, { 1, 2 } });
		System.out.println(str);

	}

	public String stringShift(String s, int[][] shift) {
		int sum = 0;

		for (int i = 0; i < shift.length; i++) {
			int[] arr = shift[i];

			if (arr[0] == 0) {
				sum = sum - arr[1];
			} else {
				sum = sum + arr[1];
			}
		}

		int len = s.length();

		if (sum > len || -sum > len) {
			sum = sum % len;
		}

		if (sum > 0) {

			int d = len - sum;

			return s.substring(d) + s.substring(0, d);
		} else if (sum < 0) {

			sum = Math.abs(sum);

			return s.substring(sum) + s.substring(0, sum);
		}
		return s;
	}

	public char[] leftShift(char[] string, int distance) {

		// 2
		// 0 1 2 3 4 5

		char[] temp = new char[string.length];
		int j = 0;
		for (int i = string.length - distance; i < string.length; i++) {
			temp[j++] = string[i];
		}

		for (int i = 0; i < string.length - distance; i++) {
			temp[j++] = string[i];
		}
		return temp;
	}

	public char[] rightShift(char[] string, int distance) {
		// c a b // 2
		char[] temp = new char[string.length];
		int j = 0;
		for (int i = distance - 1; i < string.length; i++) {
			temp[j++] = string[i];
		}

		for (int i = 0; i < string.length - distance; i++) {
			temp[j++] = string[i];
		}

		return temp;
	}
}
