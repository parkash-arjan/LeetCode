package algo.leetcode.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 2, 3 };
		List<Integer> list = new ArrayList<>();

		Collections.addAll(list, array);
		System.out.println(list);

	}
}
