class wsz_272 {
	private Map<Integer, Integer> left_all = new HashMap<>();
	private Map<Integer, Integer> left = new HashMap<>();
	private Map<Integer, Integer> right = new HashMap<>();
    /** Initialize your data structure here. */
    public wsz_272() {
        
    }
    
    public void addNum(int val) {
		if (left.containsKey(val)) {
			return;
		}

		int right_bound = Math.max(val, right.getOrDefault(val+1, Integer.MIN_VALUE));
		int left_bound = Math.min(val, left.getOrDefault(val-1, Integer.MAX_VALUE));
		left.put(val, left_bound);
		right.put(val, right_bound);
		left.put(left_bound, left_bound);
		left.put(right_bound, left_bound);
		right.put(left_bound, right_bound);
		right.put(right_bound, right_bound);

		if (right.containsKey(val+1)) {
			left_all.remove(val+1);
			left.put(val+1, left_bound);
		}

		if (left.containsKey(val-1)) {
			right.put(val-1, right_bound);
		}

		left_all.put(left_bound, right_bound);

    }
    
    public int[][] getIntervals() {
        Iterator<Integer> ite = left_all.keySet().iterator();
		int[][] result = new int[left_all.size()][2];
		int index = 0;
		while (ite.hasNext()) {
			int left = ite.next();
			result[index][0] = left;
			result[index++][1] = left_all.get(left);
		}

		return result;
    }
}
