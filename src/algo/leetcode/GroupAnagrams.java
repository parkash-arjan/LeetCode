package algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		System.out
				.println(new GroupAnagrams().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

//		System.out.println(new GroupAnagrams()
//				.groupAnagrams(new String[] { "cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc" }));
//
//		System.out.println(new GroupAnagrams().hash("ill"));
//		System.out.println(new GroupAnagrams().hash("duh"));

	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {

			String key = hash(strs[i]);
			if (map.containsKey(key)) {
				map.get(key).add(strs[i]);
			} else {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(key, list);
			}

		}
		List<List<String>> result = new ArrayList<>();
		result.addAll(map.values());
		return result;
	}

	public String hash(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

//	public List<List<String>> groupAnagrams(String[] strs) {
//		Map<String, List<String>> map = new HashMap<>();
//		for (int i = 0; i < strs.length; i++) {
//			char[] charArr = strs[i].toCharArray();
//			Arrays.sort(charArr);
//			String key = new String(charArr);
//			if (map.containsKey(key)) {
//				map.get(key).add(strs[i]);
//			} else {
//				List<String> list = new ArrayList<>();
//				list.add(strs[i]);
//				map.put(key, list);
//			}
//
//		}
//		List<List<String>> result = new ArrayList<>();
//		result.addAll(map.values());
//		return result;
//	}	

//	public List<List<String>> groupAnagrams(String[] strs) {
//
//		List<String> duplicates = sortString(strs);
//		Map<String, List<String>> map = new HashMap<>();
//
//		for (int i = 0; i < duplicates.size(); i++) {
//
//			if (map.containsKey(duplicates.get(i))) {
//				map.get(duplicates.get(i)).add(strs[i]);
//			} else {
//				List<String> list = new ArrayList<>();
//				list.add(strs[i]);
//				map.put(duplicates.get(i), list);
//			}
//
//		}
//
//		List<List<String>> result = new ArrayList<>();
//		result.addAll(map.values());
//
//		return result;
//	}
//
//	public List<String> sortString(String[] strs) {
//		List<String> duplicates = new ArrayList<>();
//		for (int i = 0; i < strs.length; i++) {
//			char[] charArr = strs[i].toCharArray();
//			Arrays.sort(charArr);
//			duplicates.add(new String(charArr));
//		}
//
//		return duplicates;
//	}
}
