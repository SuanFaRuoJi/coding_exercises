class RandomizedSet {
	private Map<Integer, Integer> reference;
	private List<Integer> store;
	private Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
		store = new ArrayList<>();
		reference = new HashMap<>();
		rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (reference.containsKey(val)) {
			return false;
		}
		reference.put(val, store.size());
		store.add(val);
		return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
		if (!reference.containsKey(val)) {
			return false;
		}
		int last_index = store.size() - 1, cur_index = reference.get(val);
		int last_val = store.get(last_index), cur_val = val;

		store.remove(last_index);
        if (last_index != cur_index) {
		    store.set(cur_index, last_val);
        }

		reference.remove(cur_val);
        if (last_index != cur_index) {
		    reference.put(last_val, cur_index);
        }
		return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(store.size());
		return store.get(index);
    }
}
