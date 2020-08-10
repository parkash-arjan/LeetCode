package algo.leetcode.map;

import java.util.LinkedList;

class MyHashMap {
	private int capacity = 1;
	private LinkedList<Entry>[] table;

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		// "put", "put", "get", "get", "put", "get", "remove", "get"
		// [1,1], [2,2], [1], [3], [2,1], [2], [2], [2]
		map.put(1, 1);
		map.put(2, 2);

		map.print();
		// System.out.println(map.get(3));
		map.put(2, 1);
		map.print();
		// System.out.println(map.get(2));
		map.remove(2);
		map.print();
		map.remove(1);
		map.print();
		// System.out.println(map.get(2));
	}

	public MyHashMap() {
		table = new LinkedList[capacity];
	}

	public void put(int key, int value) {

		int index = hash(key);
		LinkedList<Entry> list = table[index];

		if (list == null) {
			list = new LinkedList<>();
			list.add(new Entry(key, value));
			table[index] = list;
		} else {

			for (Entry entry : list) {
				if (entry.key == key) {
					entry.value = value;
					return;
				}
			}

			list.add(new Entry(key, value));
		}

	}

	public int get(int key) {

		int index = hash(key);
		LinkedList<Entry> list = table[index];

		if (list != null) {
			for (Entry entry : list) {
				if (entry.key == key) {
					return entry.value;
				}
			}
		}

		return -1;
	}

	public void remove(int key) {

		int index = hash(key);
		LinkedList<Entry> list = table[index];

		if (list != null) {
			for (Entry entry : list) {
				if (entry.key == key) {
					list.remove(entry);
					break;
				}
			}

			if (table[index].isEmpty())
				table[index] = null;
		}

	}

	private int hash(int key) {
		return key % capacity;
	}

	public void print() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null)
				System.out.println(table[i]);
		}
		System.out.println("---------");

	}
}

class Entry {
	public Entry(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int key;
	public int value;

	@Override
	public String toString() {
		return String.format("Entry [key=%s, value=%s]", key, value);
	}

}