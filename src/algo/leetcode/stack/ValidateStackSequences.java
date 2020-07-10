package algo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateStackSequences {
	public static void main(String[] args) {
		boolean validateStackSequences = false;
		validateStackSequences = validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 });
		System.out.println(validateStackSequences);

		validateStackSequences = validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 });
		System.out.println(validateStackSequences);

		validateStackSequences = validateStackSequences(new int[] { 2, 1, 0 }, new int[] { 1, 2, 0 });
		System.out.println(validateStackSequences);

		validateStackSequences = validateStackSequences(new int[] { 2, 3, 0, 1 }, new int[] { 0, 3, 2, 1 });
		System.out.println(validateStackSequences);
	}

	/*
	 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] Output: true Explanation:
	 * We might do the following sequence: push(1), push(2), push(3), push(4), pop()
	 * -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
	 * 
	 * 
	 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2] Output: false Explanation:
	 * 1 cannot be popped before 2.
	 */
	public static boolean validateStackSequences(int[] pushed, int[] popped) {

		Deque<Integer> stack = new ArrayDeque<>();
		int j = 0;
		for (int i = 0; i < pushed.length; i++) {

			if (pushed[i] != popped[j]) {
				stack.push(pushed[i]);
			} else {
				j++;
				while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
					stack.pop();
					j++;
				}

			}

		}

		if (stack.size() != popped.length - j) {
			return false;
		}

		for (int k = j; k < popped.length; k++) {

			if (stack.pop() != popped[k]) {
				return false;
			}

		}

		return true;
	}

}