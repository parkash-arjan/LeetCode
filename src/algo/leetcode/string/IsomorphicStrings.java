package algo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {

		Map<Character, Character> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {

			Character inputSourceChar = s.charAt(i);
			Character inputMappingChar = t.charAt(i);

			Character sourceKey = map.get(inputSourceChar);

			if (sourceKey == null) {

				if (map.values().contains(inputMappingChar)) {
					return false;
				}

				map.put(inputSourceChar, inputMappingChar);

			} else {
				if (!inputMappingChar.equals(sourceKey)) {
					return false;
				}
			}

		}

		return true;
	}
}
