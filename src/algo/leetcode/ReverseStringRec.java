package algo.leetcode;

public class ReverseStringRec {
	public static void main(String[] args) {
		printRec("PARKASH", 0);
	}

	public static void printRec(String str, int index) {

		if (index == str.length()) {
			return;
		}

		printRec(str, index + 1);
		System.out.print(str.charAt(index));
	}
}
