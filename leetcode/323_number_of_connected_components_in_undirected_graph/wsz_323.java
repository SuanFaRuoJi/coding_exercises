class Solution {
	public int countComponents(int n, int[][] edges) {
		int[] tree = new int[n];
		for (int i=0; i<n; i++) {
			tree[i] = i;
		}
		int count = n;
		for (int[] edge : edges) {
			if (union(tree, edge[0], edge[1])) {
				count --;
			}
		}
		return count;
	}

	private static int find(int[] tree, int index) {
		if (tree[index] == index) {
			return index;
		}

		int source = find(tree, tree[index]);
		tree[index] = source; // path compression
		return source;
	}

	private static boolean union(int[] tree, int a, int b) {
		int a_source = find(tree, a), b_source = find(tree, b);
		if (a_source == b_source) {
			return false;
		}
		tree[a_source] = b_source; // a under b

		return true;
	}
}
