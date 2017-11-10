
public class Hashtable {
	
	class Node {
		String key;
		String value;
		Node next;
	}
	
	private Node[] table;
	private int bucket;
	
	private int getIndex(String k) {
		int n = k.hashCode();
		if (n < 0)
			n = -n;
		return n % bucket;
	}
	
	public Hashtable() {
		bucket = 262143;
		table = new Node[bucket];
		for (int i = 0; i < bucket; i++)
			table[i] = new Node();
	}
	
	public boolean containsKey(String key) {
		Node temp = table[getIndex(key)];
		while (temp.next != null) {
			temp = temp.next;
			if (temp.key.equals(key))
				return true;
		}
		return false;
	}
	
	public String get(String key) {
		Node temp = table[getIndex(key)];
		while (temp.next != null) {
			temp = temp.next;
			if (temp.key.equals(key))
				return temp.value;
		}
		return null;
	}
	
	public void put(String key, String value) {
		Node temp = table[getIndex(key)];
		while (temp.next != null) {
			temp = temp.next;
			if (temp.key.equals(key)) {
				temp.value = value;
				return;
			}
		}
		Node newNode = new Node();
		temp.next = newNode;
		newNode.key = key;
		newNode.value = value;
	}
	
	public String remove(String key) throws Exception {
		Node temp = table[getIndex(key)];
		while (temp.next != null) {
			if (temp.next.key.equals(key)) {
				String v = temp.next.value;
				temp.next = temp.next.next;
				return v;
			}
			temp = temp.next;
		}
		throw new Exception("The key do not exist.");
	}
	
	
}
