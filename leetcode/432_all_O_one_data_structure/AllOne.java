class AllOne {
	class Node {
		int freq;
		Set<String> keys;
		Node prev;
		Node next;

		Node(int f) {
			freq = f;
			keys = new HashSet<>();
			prev = null;
			next = null;
		}
	}

	Node head;
	Node tail;
	HashMap<String, Node> reference;

    /** Initialize your data structure here. */
    public AllOne() {
		head = null;
		tail = null;
		reference = new HashMap<>();
    }

	private void deleteNode(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		}

		if (node == head) {
			head = node.next;
		}
		
		if (node == tail) {
			tail = node.prev;
		}
	}

	private void addNodeBehind(Node node, Node to_add) {
		if (node == null) { // no node in the list
			head = to_add;
			tail = to_add;
			return;
		}

		to_add.prev = node;
		to_add.next = node.next;
		if (node.next != null) {
			node.next.prev = to_add;
		}
		node.next = to_add;

		if (node == tail) {
			tail = to_add;
		}
	}

	private void addNodeBefore(Node node, Node to_add) {
		if (node == null) {
			head = to_add;
			tail = to_add;
			return;
		}

		to_add.next = node;
		to_add.prev = node.prev;
		if (node.prev != null) {
			node.prev.next = to_add;
		}
		node.prev = to_add;

		if (node == head) {
			head = to_add;
		}
	}

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
		Node cur = null, new_cur;
		if (reference.containsKey(key)) {
			cur = reference.get(key);
			cur.keys.remove(key);
		}

		if (cur == null) {
			if (head != null && head.freq == 1) {
				head.keys.add(key);
				new_cur = head;
			} else {
				Node to_add = new Node(1);
				to_add.keys.add(key);
				addNodeBefore(head, to_add);
				new_cur = to_add;
			}
		} else {
			Node next = cur.next;
			if (next != null && next.freq == cur.freq+1) {
				next.keys.add(key);
				new_cur = next;
			} else {
				to_add.keys.add(key);
				Node to_add = new Node(cur.freq+1);
				addNodeBehind(cur, to_add);
				new_cur = to_add;
			}
		}
	
		if (cur != null && cur.keys.isEmpty()) {
			deleteNode(cur);
		}
		reference.put(key, new_cur);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
		if (!reference.containsKey(key)) {
			return;
		}

		Node cur = reference.get(key);
		cur.keys.remove(key);

		Node prev = cur.prev;
		if (prev != null && prev.freq == cur.freq-1) {
			reference.put(key, prev);
			prev.keys.add(key);
		} else if (cur.freq != 1) {
			reference.put(key, to_add);
			Node to_add = new Node(cur.freq-1);
			to_add.keys.add(key);
			addNodeBefore(cur, to_add);
		}

		if (cur.keys.isEmpty()) {
			deleteNode(cur);
		}
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
		if (tail == null) {
			return  "";
		}

		return tail.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
		if (head == null) {
			return "";
		}

		return head.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
