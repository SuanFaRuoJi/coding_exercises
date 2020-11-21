class wsz_69 {
    public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
        long l = 1, r = x;

		while (l+1 < r) {
			long mid = (l+r) / 2;
			if (mid * mid <= x) {
				l = mid;
			} else {
				r = mid;
			}
		}

		return (int)l;
    }
}
