package algo.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class GcdofStrings {

	public static void main(String[] args) {
		GcdofStrings gcd = new GcdofStrings();
		String gcdOfStrings = gcd.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
				"TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX");

//		String gcdOfStrings = gcd.gcdOfStrings("ABABAB", "ABAB");
//
//		String gcdOfStrings = gcd.gcdOfStrings("ABC", "ABCABC");

		System.out.println(gcdOfStrings);
	}

	public String gcdOfStrings(String string1, String string2) {

		String result = "";
		if (string1.length() <= string2.length()) {
			result = gcd(string1, string2);
		} else {
			result = gcd(string2, string1);
		}

		return result;

	}

	// str1 is smaller
	public String gcd(String str1, String str2) {

		int len = gcd(str1.length(), str2.length());
		String gcd = str1.substring(0, len);

		StringBuilder tempSb1 = new StringBuilder();
		for (int i = 0; i < str1.length() / gcd.length(); i++) {
			tempSb1.append(gcd);
		}

		StringBuilder tempSb2 = new StringBuilder();
		for (int i = 0; i < str2.length() / gcd.length(); i++) {
			tempSb2.append(gcd);
		}

		return (tempSb1.toString().equals(str1) && tempSb2.toString().equals(str2)) ? gcd : "";
	}

	// a <b
	public int gcd(int a, int b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}

}
