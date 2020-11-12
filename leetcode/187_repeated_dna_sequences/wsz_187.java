class Solution {
	private static final int mask = ~(3 << 20);
	private static final int extract = (3 << 18);
	private static final char[] use = new char[] {'A', 'G', 'C', 'T'};

    public List<String> findRepeatedDnaSequences(String s) {
		Map<Integer, Integer> visited = new HashMap<>();
		List<String> result = new ArrayList<>();
        int hash = 0;
		for (int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			hash = encode(hash, cur);
			if (i >= 9) {
				if (visited.contains(hash)) {
					int end = visited.get(hash);
					result.add(s.substring(end-9, end+1));
				} else {
					visited.put(hash, i);
				}
			}
		}
		return result;
    }

	private int encode(int prev, char next) {
		int digits = 0;
		switch (next) {
			case 'G':
				digits = 1;
				break;
			case 'C':
				digits = 2;
				break;
			case 'T':
				digits = 3;
				break;
		}
		return (prev << 2 | next) & mask;
	}
}
