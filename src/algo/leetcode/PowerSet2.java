package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet2 {

	public static void main(String[] args) {
		PowerSet2 ps = new PowerSet2();
		List<String> result = new ArrayList<>();
		result.add("");

		String inputString = "ABC";
		for (int i = 0; i < inputString.length(); i++) {
			result = ps.powerSetHelper(String.valueOf(inputString.charAt(i)), result);
		}
		System.out.println(result);
	}

	public List<String> powerSetHelper(String inputString, List<String> result) {

		List<String> temp = new ArrayList<>();
		temp.addAll(result);
		for (String string : result) {
			temp.add(inputString.concat(string));
		}
		return temp;
	}

}
