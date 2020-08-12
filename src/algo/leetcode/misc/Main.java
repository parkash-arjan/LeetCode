package algo.leetcode.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
//		Integer[] array = new Integer[] { 1, 2, 3 };
//		List<Integer> list = new ArrayList<>();
//
//		Collections.addAll(list, array);
//		System.out.println(list);
//
//		String string = "1";
//		System.out.println(string);

//		String str = "012";
//		System.out.println(str);

//		StringBuilder builder = new StringBuilder("012");
//		System.out.println(builder.length());
//		System.out.println(builder.toString());
//		builder.deleteCharAt(0);
//		System.out.println(builder.toString());
//
//		StringBuilder deleteCharAt = builder.deleteCharAt(0);
//		System.out.println(builder.toString());
//		System.out.println(deleteCharAt.toString());
//
//		System.out.println(deleteCharAt.hashCode() + " - " + builder.hashCode());

//		builder.deleteCharAt(0);
//		System.out.println(builder.toString());
//
//		builder.insert(0, "9");
//		System.out.println(builder.length());

		StringBuilder builder = new StringBuilder("012");

		StringBuilder subBuilder = new StringBuilder(builder).deleteCharAt(0);

		System.out.println(builder);
		System.out.println(subBuilder);

	}
}
