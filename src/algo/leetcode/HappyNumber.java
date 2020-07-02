package algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(19));

	}

	public boolean isHappy(int n) {
		Set<Integer> isSeenSet = new HashSet<>();
		return isHappyRec(n, isSeenSet);
	}

	public boolean isHappyRec(int num, Set<Integer> isSeenSet) {
		isSeenSet.add(num);
		List<Integer> digits = getDigits(num);
		int happyNum = getSum(digits);

		if (happyNum == 1) {
			return true;
		} else if (isSeenSet.contains(happyNum)) {
			return false;
		} else {
			return isHappyRec(happyNum, isSeenSet);
		}
	}

	public int getSum(List<Integer> digits) {
		int sum = 0;
		for (Integer digit : digits) {
			sum = sum + (digit * digit);
		}
		return sum;
	}

	public List<Integer> getDigits(int num) {
		List<Integer> digits = new ArrayList<>();

		while (num >= 10) {
			digits.add(num % 10);
			num = num / 10;
		}
		digits.add(num);

		return digits;
	}

}
