package algo.leetcode;

public class StringDivisibility {

	public static void main(String[] args) {
		int findSmallestDivisor = -239;

//		findSmallestDivisor = findSmallestDivisor("lrbb", "lrbb");
//		System.out.println(findSmallestDivisor);

//		 findSmallestDivisor = findSmallestDivisor("rbrb", "rbrb");
//		System.out.println(findSmallestDivisor);

//		findSmallestDivisor = findSmallestDivisor("abcabcabc", "abcabcabc");
//		System.out.println(findSmallestDivisor);

//		findSmallestDivisor = findSmallestDivisor(
//				"wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd",
//				"wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd");
//
//		System.out.println(findSmallestDivisor);

		findSmallestDivisor = findSmallestDivisor("jj", "jj");
		System.out.println(findSmallestDivisor);

	}

	public static int findSmallestDivisor(String s, String t) {

		if (s.length() % t.length() != 0) {
			return -1;
		}

		int lengthDiff = s.length() / t.length();

		StringBuilder buff = new StringBuilder();
		for (int i = 1; i <= lengthDiff; i++) {
			buff.append(t);
		}

		if (s.equalsIgnoreCase(buff.toString())) {
			if (s.replace(s.substring(0, 1), "").length() == 0) {
				return 1;
			}

			String baseRepeatingSubstring = getBaseRepeatingSubstring(t);
			if (baseRepeatingSubstring == null) {
				return t.length();
			} else {
				return baseRepeatingSubstring.length();
			}
		} else {
			return -1;
		}

	}

	public static String getBaseRepeatingSubstring(String inputString) {
		for (int i = inputString.length() / 2; i >= 1; i--) {
			if (inputString.length() % i == 0) {
				StringBuilder baseTempString = new StringBuilder();
				String baseSubString = inputString.substring(0, i);
				for (int j = 0; j < inputString.length() / i; j++) {
					baseTempString.append(baseSubString);
				}
				if (baseTempString.toString().equals(inputString)) {
					return baseTempString.substring(0, i);

				}
			}
		}
		return null;
	}
}
