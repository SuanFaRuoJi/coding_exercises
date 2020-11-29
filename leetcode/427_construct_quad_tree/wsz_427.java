class wsz_427 {
	public Node construct(int[][] grid) {
		int height = grid.length, width;
		if (height == 0) {
			return new Node();
		}
		width = grid[0].length;
		if  (width == 0) {
			return new Node();
		}

		int[][] sum = new int[height][width];
		process(grid, sum);

		return treeify(sum, -1, -1, height-1, width-1);
    }

	private Node treeify(int[][] sum, int x_1, int y_1, int x_2, int y_2) {
		int total = (x_2 - x_1) * (y_2 - y_1);
		int actual = square_sum(sum, x_1, y_1, x_2, y_2);
		Node current = new Node();
		current.val = actual != 0;
		if (actual == total || actual == 0) { // leaf
			current.isLeaf = true;
			return current;
		}

		int x_mid = (x_1+x_2) / 2;
		int y_mid = (y_1+y_2) / 2;

		current.topLeft = treeify(sum, x_1, y_1, x_mid, y_mid);
		current.topRight = treeify(sum, x_1, y_mid, x_mid, y_2);
		current.bottomLeft = treeify(sum, x_mid, y_1, x_2, y_mid);
		current.bottomRight = treeify(sum, x_mid, y_mid, x_2, y_2);

		return current;
	}

	private void process(int[][] grid, int[][] sum) {
		for (int i=0; i<grid.length; i++) {
			sum[i][0] = grid[i][0];
			for (int j=1; j<grid[i].length; j++) {
				sum[i][j] = grid[i][j] + sum[i][j-1];
			}
		}

		for (int j=0; j<grid[0].length; j++) {
			for (int i=1; i<grid.length; i++) {
				sum[i][j] += sum[i-1][j];
			}
		}
	}

	private int square_sum(int[][] sum, int x_1, int y_1, int x_2, int y_2) {
		int top_left = (x_1 >= 0 && y_1 >= 0) ? sum[x_1][y_1] : 0;
		int top_right = (x_1 >= 0) ? sum[x_1][y_2] : 0;
		int bottom_left = (y_1 >= 0) ? sum[x_2][y_1] : 0;
		int bottom_right = sum[x_2][y_2];

		return bottom_right + top_left - top_right - bottom_left;
	}
}
