class wsz_200 {
	public int numIslands(char[][] grid) {
        int height = grid.length, width = grid[0].length;
		int[] tree = new int[height * width];
		for (int i = 1; i<tree.length; i++) {
			tree[i] = i;
		}
		int num = 0, merge = 0;

		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (grid[i][j] == '0') {
					continue;
				}
				num ++;
				int index = encode(i, j, width);
				if (i+1 < height && grid[i+1][j] == '1') { // down
					int compare = encode(i+1, j, width);
					if (union(tree, index, compare)) {
						merge ++;
					}
				}
				if (j+1 < width && grid[i][j+1] == '1') { // down
					int compare = encode(i, j+1, width);
					if (union(tree, index, compare)) {
						merge ++;
					}
				}
			}
		}

		return num - merge;
    }

	private int encode(int i, int j, int width) {
		return i * width + j;
	}

	private int[] decode(int index, int width) {
		return new int[]{index / width, index % width};
	}

	private int find(int[] tree, int index) {
		if (tree[index] == index) {
			return index;
		}

		int result = find(tree, tree[index]);
		tree[index] = result;
		return result;
	}

	private boolean union(int[] tree, int a, int b) {
		int a_root = find(tree, a), b_root = find(tree, b);
		if (a_root == b_root) {
			return false;
		}

		tree[b_root] = a_root;
		return true;
	}
}
