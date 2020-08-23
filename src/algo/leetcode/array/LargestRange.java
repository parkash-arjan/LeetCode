package algo.leetcode.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LargestRange {

	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 2, 5, 6, 7, 8, 9, 10, 16, 17 };
		int[] largestRange = largestRange(array);

		System.out.println("[" + largestRange[0] + "," + largestRange[1] + "]");
	}

	public static int[] largestRange(int[] array) {

		Set<Integer> hashSet = new HashSet<>();
		Set<Integer> result = new HashSet<>();

		for (int i = 0; i < array.length; i++) {
			hashSet.add(array[i]);
		}

		int i = 0;
		while (i < array.length) {
			if (hashSet.contains(array[i])) {
				Set<Integer> currentRange = check(array[i], hashSet);
				i = currentRange.size();
				if (currentRange.size() > result.size()) {
					result = currentRange;
				}
			} else {
				i++;
			}
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		Iterator<Integer> it = result.iterator();

		while (it.hasNext()) {
			Integer value = it.next();
			max = Math.max(max, value);
			min = Math.min(min, value);

		}

		return new int[] { min, max };
	}

	private static Set<Integer> check(int number, Set<Integer> set) {
		Set<Integer> rangeSet = new HashSet<>();
		checkHelper(number, set, rangeSet);
		return rangeSet;
	}

	private static void checkHelper(int number, Set<Integer> set, Set<Integer> temp) {

		if (set.contains(number)) {
			temp.add(number);
			set.remove(number);
			checkHelper(number + 1, set, temp);
			checkHelper(number - 1, set, temp);
		}

	}

}
