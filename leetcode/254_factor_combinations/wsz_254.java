class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		search(n, 2, cur, result);
		return result;
    }

	private void search(int n, int start, List<Integer> cur, List<List<Integer>> result) {
		if (n == 1) { // found
			if (cur.size() > 1) {
				result.add(new ArrayList(cur));
			}
			return;
		}

		int i = start;
		while (i * i <= n) {
			if (n % i == 0) {
				cur.add(i);
				search(n/i, i, cur, result);
				cur.remove(cur.size()-1);
			}
			i ++;
		}
		cur.add(n);
		search(1, i, cur, result);
		cur.remove(cur.size()-1);
	}
}
