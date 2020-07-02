package algo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(singleNumber(new int[] { 1, 0, 1 }));

	}

	public static int singleNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (list.contains(Integer.valueOf(nums[i]))) {
				list.remove(Integer.valueOf(nums[i]));
			} else {
				list.add(Integer.valueOf(nums[i]));
			}
		}
		return list.get(0);

	}

	public static int singleNumber1(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}

		return set.iterator().next();

	}
}
