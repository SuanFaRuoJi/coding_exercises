class Solution {
	char[][] literals = {{'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'}, {'M'}};
	
    public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
        int[] weights = new int[] {1000, 100, 10, 1};
		for (int i=0; i<weights.length; i++) {
			int weight = weights[i];
			int digit = num / weight;
			buildDigit(digit, literals[3-i], sb);
			num = num - weight * digit;
		}

		return sb.toString();
    }

	private void buildDigit(int val, char[] symbols, StringBuilder sb) {
		if (val == 4) {
			sb.append(symbols[0]);
			sb.append(symbols[1]);
			return;
		}
		if (val == 9) {
			sb.append(symbols[0]);
			sb.append(symbols[2]);
            return;
		}
		if (val >= 5) {
			sb.append(symbols[1]);
			buildDigit(val-5, symbols, sb);
            return;
		}
		for (int i=0; i<val; i++) {
			sb.append(symbols[0]);
		}
	}
}
