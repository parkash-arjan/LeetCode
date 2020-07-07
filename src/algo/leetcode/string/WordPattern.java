package algo.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

	public static void main(String[] args) {
		WordPattern wordPattern = new WordPattern();
		System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
		System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));

	}

	// "abba", str = "dog cat cat dog" //true
	// "abba", str = "dog dog dog dog" //false
	public boolean wordPattern(String pattern, String str) {

		char[] charArray = pattern.toCharArray();
		String[] split = str.split(" ");

		if (charArray.length != split.length)
			return false;

		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < charArray.length; i++) {
			String value = map.get(charArray[i]);
			if (value != null) {
				if (!value.equalsIgnoreCase(split[i])) {
					return false;
				}
			} else {
				set.add(split[i]);
				map.put(charArray[i], split[i]);
			}
		}

		return set.size() == map.size();
	}

}
