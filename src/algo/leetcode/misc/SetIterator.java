package algo.leetcode.misc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {

	public static void main(String[] args) {

		Set<Integer> set = new HashSet<>();
		set.add(5);
		set.add(3);
		set.add(4);
		set.add(1);
		set.add(2);

		Iterator<Integer> iterator = set.iterator();

		while (iterator.hasNext()) {
			if (iterator.next() == 4)
				iterator.remove();
		}

		iterator = set.iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());

		}
	}
}
