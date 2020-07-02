package algo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static void main(String[] args) {
		new FizzBuzz().fizzBuzz(15).forEach(System.out::println);
	}

	public List<String> fizzBuzz(int n) {
		List<String> fizzBizzList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				fizzBizzList.add("FizzBuzz");
			} else if (i % 3 == 0) {
				fizzBizzList.add("Fizz");
			} else if (i % 5 == 0) {
				fizzBizzList.add("Buzz");
			} else {
				fizzBizzList.add(i + "");
			}
		}
		return fizzBizzList;
	}
}
