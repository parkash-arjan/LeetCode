package algo.leetcode.string;

public class AddStrings {
	// int a=Integer.parseInt(String.valueOf(c));
	// int a = Character.getNumericValue(char1);
	public static void main(String[] args) {

//		char[] nums = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
//
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i] - 48);
//		}

		AddStrings addStrings = new AddStrings();
		System.out.println(addStrings.addStrings("0", "0"));

	}

	public String addStrings(String num1, String num2) {

		int i = num1.length() - 1;
		int j = num2.length() - 1;

		int carry = 0;
		StringBuilder output = new StringBuilder();
		while (i >= 0 || j >= 0) {

			int sum = getDigit(num1, i--) + getDigit(num2, j--) + carry;
			output.append(sum % 10);
			carry = sum / 10;

		}

		if (carry != 0)
			output.append(carry);

		return output.reverse().toString();
	}

	public String addStringsV1(String num1, String num2) {

		if (num1.length() >= num2.length()) {
			return add(num1, num2);
		}
		return add(num2, num1);

	}

	private String add(String number1, String number2) {

		StringBuilder output = new StringBuilder();
		int carry = 0;

		int j = number2.length() - 1;

		for (int i = number1.length() - 1; i >= 0; i--) {
			int sum = getDigit(number1, i) + getDigit(number2, j--) + carry;

			output.append(sum % 10);
			carry = sum / 10;
		}

		if (carry != 0)
			output.append(carry);

		return output.reverse().toString();
	}

	public int getDigit(String number, int i) {

		if (i >= number.length() || i < 0) {
			return 0;
		}

		return number.charAt(i) - 48;
	}

	public int addWithCarry(char char1, char char2, int carry) {
		return add(char1, char2) + carry;
	}

	public int add(char char1, char char2) {
		int a = charToInt(char1);
		int b = charToInt(char2);
		return a + b;
	}

	public int charToInt(char ch) {
		return ch - 48;
	}
}
