package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

	public static void main(String[] args) {
		PowerSet ps = new PowerSet();
		List<String> powerSetHelper = ps.powerSetHelper("ABC", new ArrayList<>());
		System.out.println(powerSetHelper);
	}

	public List<String> powerSetHelper(String inputString, List<String> result) {

		if (inputString.length() == 1) {
			return Arrays.asList("", inputString);
		}

		int len = inputString.length();
		for (int i = 0; i < len; i++) {
			List<String> partialSubSets = Arrays.asList("", String.valueOf(inputString.charAt(i))) ;//powerSetHelper(String.valueOf(inputString.charAt(i)), result);
			merge(partialSubSets, result);
		}
		return result;
	}

	private void merge(List<String> partialSubSet, List<String> resultSet) {

		if (resultSet.isEmpty()) {
			resultSet.addAll(partialSubSet);
			return;
		}
		List<String> temp = new ArrayList<>();
		for (String partialSubSetItem : partialSubSet) {
			for (String resultSetItem : resultSet) {
				temp.add(partialSubSetItem + resultSetItem);
			}
		}

		resultSet.clear();
		resultSet.addAll(temp);
	}

}
