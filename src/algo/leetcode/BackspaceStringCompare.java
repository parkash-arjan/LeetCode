package algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {

	public static void main(String[] args) {

		System.out.println(new BackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
	}

	public boolean backspaceCompare(String S, String T) {
		return applyBackspace(S, T);
	}

	private boolean applyBackspace(String s, String t) {

		Deque<Character> stackS = getStack(s);
		Deque<Character> stackT = getStack(t);

		if (stackS.size() != stackT.size()) {
			return false;
		}

		while (!stackS.isEmpty()) {
			if (!stackS.pop().equals(stackT.pop()))
				return false;
		}

		return true;
	}

	private Deque<Character> getStack(String string) {

		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '#') {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(string.charAt(i));
			}
		}
		return stack;
	}
}
