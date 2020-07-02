package algo.leetcode;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		//int longestCommonSubsequence = new LongestCommonSubsequence().longestCommonSubsequence("ACE", "ABCDEF");
		
		//int longestCommonSubsequence = new LongestCommonSubsequence().longestCommonSubsequence("ABC", "ABC");
		//int longestCommonSubsequence = new LongestCommonSubsequence().longestCommonSubsequence("ABC", "DEF");
		
		 int longestCommonSubsequence = new LongestCommonSubsequence().longestCommonSubsequence("ABCDGH", "AEDFHR");
		System.out.println( longestCommonSubsequence);
	}

	public int longestCommonSubsequence(String text1, String text2) {
		char[] string1 = text1.toCharArray();
		char[] string2 = text2.toCharArray();

		return compute(string1, string2);
	}

	private int compute(char[] string1, char[] string2) {

		int len = 0;
		int k = 0;
		int result = 0;
		for (int i = 0; i < string1.length;) {
			String str = "";
			for (int j = 0; j < string2.length && i < string1.length; j++) {
				if (string1[i] == string2[j]) {
					len++;
					i++;
					result = Math.max(result, len);
					str = str + string2[j];
				}

			}
			i = ++k;
			len = 0;
			System.out.println(str);
		}
		return result;
	}
}