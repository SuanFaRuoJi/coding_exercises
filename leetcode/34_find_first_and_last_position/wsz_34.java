class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        return new int[] {search(nums, target, true), search(nums, target, false)};
    }

    private int search(int[] nums, int target, boolean left) {
		int most = left ? nums.length : -1;
		if (nums[0] == target) {
			if (left) {
				return 0;
			}
			most = 0;
		}
		if (nums[nums.length-1] == target) {
			if (!left) {
				return nums.length-1;
			}
			most = nums.length-1;
		}

		int i=0, j=nums.length-1;
		while (i+1 < j) {
			int mid = (i+j)/2;
			int val = nums[mid];
			if (val > target) {
				j = mid;
			} else if (val < target) {
				i = mid;
			} else if (left) {
				most = Math.min(most, mid);
				j = mid;
			} else {
				most = Math.max(most, mid);
				i = mid;
			}
		}
		return most == nums.length ? -1 : most;
	}}
