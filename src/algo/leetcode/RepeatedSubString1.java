package algo.leetcode;

public class RepeatedSubString1 {

	public static void main(String[] args) {
//		getBaseRepeatingString("abcabcabc");
//		getBaseRepeatingString("lrbbll");
//		getBaseRepeatingString("abcaabca");
//		getBaseRepeatingString("rbrb");
//		getBaseRepeatingString("lrlrbb");
//		getBaseRepeatingString("wwrrttxx");

		repeatedSubstringPattern2("abcabcabc");
		repeatedSubstringPattern2("lrbbll");
		repeatedSubstringPattern2("abcaabca");
		repeatedSubstringPattern2("rbrb");
		repeatedSubstringPattern2("lrlrbb");
		repeatedSubstringPattern2("wwrrttxx");
		// System.out.println();
	}

	public static String getBaseRepeatingString(String str) {

		for (int i = 0; i < str.length() / 2; i++) {
			String string = str.substring(0, i + 1);
			if (str.contains(string.concat(string))) {
				System.out.println(string);
				return string;
			}
		}
		return null;

	}

	public static String repeatedSubstringPattern2(String str) {
		for (int i = str.length() / 2; i >= 1; i--) {
			if (str.length() % i == 0) {
				StringBuilder tempStr = new StringBuilder();
				String partStr = str.substring(0, i);
				for (int j = 0; j < str.length() / i; j++) {
					tempStr.append(partStr);
				}
				if (tempStr.toString().equals(str)) {
					String substring = tempStr.substring(0, i);
					System.out.println(substring);
					return substring;
				}
			}
		}
		return null;
	}

	public static boolean repeatedSubstringPattern(String str) {
		for (int i = str.length() / 2; i >= 1; i--) {
			if (str.length() % i == 0) {
				StringBuilder tempStr = new StringBuilder();
				String partStr = str.substring(0, i);
				for (int j = 0; j < str.length() / i; j++) {
					tempStr.append(partStr);
				}
				if (tempStr.toString().equals(str)) {
					return true;
				}
			}
		}
		return false;
	}
}
