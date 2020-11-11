public class wsz_lc973 {
	Random rand = new Random();


    public int[][] kClosest(int[][] points, int K) {
		int[][] copy = new int[points.length][];
		System.arraycopy(points, 0, copy, 0, points.length);
		quick_select(copy, 0, copy.length-1, K);
		return Arrays.copyOfRange(copy, 0, K);
    }

	private void quick_select(int[][] points, int l, int r, int k) {
        System.out.println(l + " " + r);
        if (r < l || r-l+1 == k) {
            return;
        }
		
        int i = l, j = r;
        int[] pivot = points[r];
        while (i <= j) {
            if (compare(points[i], pivot)) {
                i++;
            } else {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                j --;
            }
        }
		int count = (i-l);
		if (count < k) {
			quick_select(points, i, r, k-count);
		} else if (count > k) {
			quick_select(points, l, j-1, k);
		}
	}

	private boolean compare(int[] a, int[] b) {
		return (a[0] * a[0] + a[1] * a[1]) <= (b[0] * b[0] + b[1] * b[1]);
	}
}
