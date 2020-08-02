package algo.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IntersectionOfThreeSortedArrays {

	public static void main(String[] args) {
		List<Integer> result = arraysIntersection(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 5, 7, 9 },
				new int[] { 1, 3, 4, 5, 8 });
		System.out.println(result);
	}

	public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

		Map<Integer, Integer> map = new HashMap<>();

		fillMap(arr1, map);
		fillMap(arr2, map);
		fillMap(arr3, map);

		Set<Entry<Integer, Integer>> values = map.entrySet();
		List<Integer> result = new ArrayList<>();
		for (Entry<Integer, Integer> entry : values) {
			if (entry.getValue() >= 3) {
				result.add(entry.getKey());

			}
		}

		Collections.sort(result);
		return result;
	}

	public static void fillMap(int[] arr, Map<Integer, Integer> map) {
		for (int i = 0; i < arr.length; i++) {
			map.merge(Integer.valueOf(arr[i]), 1, Integer::sum);
		}
	}

//	public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
//
//		Map<Integer, Integer> map = new HashMap<>();
//
//		for (int i = 0; i < arr1.length; i++) {
//
//			map.merge(Integer.valueOf(arr1[i]), 1, Integer::sum);
//		}
//
//		for (int i = 0; i < arr2.length; i++) {
//			map.merge(Integer.valueOf(arr2[i]), 1, Integer::sum);
//		}
//
//		for (int i = 0; i < arr3.length; i++) {
//			map.merge(Integer.valueOf(arr3[i]), 1, Integer::sum);
//		}
//
//		Set<Entry<Integer, Integer>> values = map.entrySet();
//		List<Integer> result = new ArrayList<>();
//		for (Entry<Integer, Integer> entry : values) {
//			if (entry.getValue() >= 3) {
//				result.add(entry.getKey());
//
//			}
//		}
//
//		Collections.sort(result);
//		return result;
//	}
//	public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
//
//		Map<Integer, Integer> map = new HashMap<>();
//
//		for (int i = 0; i < arr1.length; i++) {
//			map.put(Integer.valueOf(arr1[i]), map.getOrDefault(Integer.valueOf(arr1[i]), 0) + 1);
//		}
//
//		for (int i = 0; i < arr2.length; i++) {
//			map.put(Integer.valueOf(arr2[i]), map.getOrDefault(Integer.valueOf(arr2[i]), 0) + 1);
//		}
//
//		for (int i = 0; i < arr3.length; i++) {
//			map.put(Integer.valueOf(arr3[i]), map.getOrDefault(Integer.valueOf(arr3[i]), 0) + 1);
//		}
//
//		Set<Entry<Integer, Integer>> values = map.entrySet();
//		List<Integer> result = new ArrayList<>();
//		for (Entry<Integer, Integer> entry : values) {
//			if (entry.getValue() >= 3) {
//				result.add(entry.getKey());
//
//			}
//		}
//
//		Collections.sort(result);
//		return result;
//	}
//	public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
//
//		Map<Integer, Integer> map = new HashMap<>();
//
//		for (int i = 0; i < arr1.length; i++) {
//			int count = map.getOrDefault(Integer.valueOf(arr1[i]), 0);
//			map.put(Integer.valueOf(arr1[i]), count + 1);
//		}
//
//		for (int i = 0; i < arr2.length; i++) {
//			int count = map.getOrDefault(Integer.valueOf(arr2[i]), 0);
//			map.put(Integer.valueOf(arr2[i]), count + 1);
//		}
//
//		for (int i = 0; i < arr3.length; i++) {
//			int count = map.getOrDefault(Integer.valueOf(arr3[i]), 0);
//			map.put(Integer.valueOf(arr3[i]), count + 1);
//		}
//
//		Set<Entry<Integer, Integer>> values = map.entrySet();
//		List<Integer> result = new ArrayList<>();
//		for (Entry<Integer, Integer> entry : values) {
//			if (entry.getValue() >= 3) {
//				result.add(entry.getKey());
//
//			}
//		}
//
//		Collections.sort(result);
//		return result;
//	}
}
