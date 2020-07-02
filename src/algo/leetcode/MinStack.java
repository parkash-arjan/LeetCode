package algo.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinStack {

	public static void main(String[] args) {
		MinStack stack = new MinStack();
//		stack.push(10);
//		stack.push(7);
//		stack.push(2);
//		stack.push(6);
//		stack.push(9);
//		stack.push(1);
//		stack.push(4);
//		stack.push(3);
//		stack.push(5);

//		stack.push(2147483646);
//		stack.push(2147483646);
//		stack.push(2147483647);

		stack.push(1);
		stack.push(1);
		stack.push(2);
		stack.top();
		stack.pop();

		System.out.println(stack.getMin());
		stack.pop();

		System.out.println(stack.getMin());
		stack.pop();
		stack.push(2);
		stack.top();
		System.out.println(stack.getMin());

	}

	private Deque<Integer> stack = new ArrayDeque<>();
	private Deque<Integer> minValueStack = new ArrayDeque<>();

	public MinStack() {
		stack = new ArrayDeque<>();

	}

	public void push(int x) {

		stack.push(x);

		if (minValueStack.isEmpty()) {
			minValueStack.push(x);
			return;
		}

		if (x <= minValueStack.peek()) {
			minValueStack.push(x);
		}

	}

	public void pop() {
		if (!stack.isEmpty() && stack.pop().equals(minValueStack.peek())) {
			minValueStack.pop();
		}

	}

	public int top() {
		if (!stack.isEmpty())
			return stack.peek();
		else

			return -1;
	}

	public int getMin() {
		return minValueStack.peek();
	}
}

class MinStackSingleStack {

	private Deque<List<Integer>> stack = null;

	public MinStackSingleStack() {
		stack = new ArrayDeque<>();
	}

	public void push(int x) {
		List<Integer> newItem = new ArrayList<>();
		newItem.add(x);
		if (stack.isEmpty()) {
			newItem.add(x);
		} else {
			newItem.add(Math.min(x, stack.peek().get(1)));
		}
		stack.push(newItem);

	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek().get(0);
	}

	public int getMin() {
		return stack.peek().get(1);
	}
}
