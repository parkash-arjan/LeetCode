package algo.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
	private Map<Character, List<Integer>> cache;
	private String inputString;

	public FrequencyCounter() {

	}

	public FrequencyCounter(String inputString) {
		this.inputString = inputString;
		cache = new HashMap<>();
		buildCache(inputString);
	}

	public static void main(String[] args) {

		FrequencyCounter frequencyCounter = new FrequencyCounter("aabbcdef");

		// int count = frequencyCounter.count("aabbcdef", 'a', 0, 4);
		int count = frequencyCounter.count('a', 0, 9);

		System.out.println(count);

	}

	private Map<Character, List<Integer>> buildCache(String inputString) {

		for (int i = 0; i < inputString.length(); i++) {

			char key = inputString.charAt(i);
			List<Integer> list = cache.get(key);
			if (list == null) {
				ArrayList<Integer> newList = new ArrayList<>();
				newList.add(i);
				cache.put(key, newList);
			} else {
				list.add(i);
			}

		}

		return cache;

	}

	private boolean isValid(String inputString, int beginIndex, int endIndex) {
		// O(N)
		if (inputString == null || inputString.length() == 0) {
			return false;
		}

		if (beginIndex < 0 || endIndex < 0) {
			return false;
		}

		if (beginIndex > endIndex) {
			return false;
		}

		if ((endIndex - beginIndex) > inputString.length()) {
			return false;
		}

		return true;
	}

	public int count(char inputChar, int beginIndex, int endIndex) {

		if (isValid(this.inputString, beginIndex, endIndex)) {

			if (cache == null || cache.isEmpty()) {
				return 0;
			}

			List<Integer> list = cache.get(inputChar);

			if (list == null || list.isEmpty()) {
				return 0;
			}

			return processListIndices(list, beginIndex, endIndex);

		} else {
			return 0;
		}

	}

	private int processListIndices(List<Integer> list, int beginIndex, int endIndex) {

		int count = 0;
		for (Integer index : list) {
			if (index <= endIndex && index >= beginIndex) {
				count++;
			}
		}
		return count;
	}

	public int count(String inputString, char inputChar, int beginIndex, int endIndex) {

		if (isValid(inputString, beginIndex, endIndex)) {
			String substring = inputString.substring(beginIndex, endIndex);

			int charCount = 0;
			for (int i = 0; i < substring.length(); i++) {

				if (substring.charAt(i) == inputChar) {
					charCount++;
				}
			}

			return charCount;
		} else {
			return 0;
		}

	}
}