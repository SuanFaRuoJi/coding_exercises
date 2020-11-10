class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);
		int i = 0, j = 0, k = 0;
		while (i < m || j < n) {
			if (j < n && (i == m || nums2[j] < nums1_copy[i])) {
				nums1[k++] = nums2[j++];
			}

			if (i < m && (j == n || nums1_copy[i] <= nums2[j])) {
				nums1[k++] = nums1_copy[i++];
			}
		}
		return;
	}
}
