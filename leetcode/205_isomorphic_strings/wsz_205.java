class Solution {
    public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> from = new HashMap<>(), to = new HashMap<>();
		for (int i=0; i<s.length(); i++) {
			char a = s.charAt(i), b = t.charAt(i);
			if (!from.containsKey(a)) {
				if (to.containsKey(b)) {
					return false;
				}
				from.put(a, b);
				to.put(b,a);
			} else {
				if (from.get(a) != b) {
					return false;
				}
			}
		}
		return true;
    }
}
