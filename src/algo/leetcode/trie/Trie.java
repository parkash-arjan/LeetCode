package algo.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private char value;
	private Map<Character, Trie> childs;

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

	public Trie() {
		value = '/'; // root node
		childs = new HashMap<>();
	}

	private Trie(char value) {
		this.value = value; // root node
		childs = new HashMap<>();
	}

	public void insert(String word) {

		if (word == null || word.length() == 0) {
			return;
		}
		insertHelper(new StringBuilder(word), this);

	}

	private void insertHelper(StringBuilder word, Trie root) {

		if (word.length() == 0) {
			return;
		}

		char ch = word.charAt(0);
		Trie node = root.childs.get(ch);
		if (node == null) {
			node = new Trie(ch);
			root.childs.put(ch, node);
		}

		insertHelper(new StringBuilder(word).deleteCharAt(0), node);

	}

	private boolean isFound = false;

	public boolean search(String word) {

		if (word == null || word.length() == 0) {
			return false;
		}
		searchHelper(new StringBuilder(word), this);
		boolean returnValue = isFound;
		isFound = false;
		return returnValue;
	}

	private void searchHelper(StringBuilder word, Trie root) {

		isFound = word.length() == 0 && root.childs.isEmpty();

		if (!isFound && word.length() != 0) {

			Trie node = root.childs.get(word.charAt(0));

			if (node != null) {
				searchHelper(word.deleteCharAt(0), node);
			}

		}

	}

	public boolean startsWith(String prefix) {
		return false;
	}

	@Override
	public String toString() {
		return String.format("Trie [value=%s, childs=%s]", value, childs);
	}

}
