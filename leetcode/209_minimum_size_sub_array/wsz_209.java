class wsz_209 {
	public int minSubArrayLen(int s, int[] nums) {
    	int sum = 0, future = s, min = nums.length;
		HashMap<Integer, Integer> future_map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			sum += nums[i];
			future += nums[i];

			if (future_map.containsKey(sum)) {
				min = Math.min(min, i - future_map.get(sum));
			}

			future_map.put(future, index);
		}
		return min == nums.length ? -1 : min;
    }
}
