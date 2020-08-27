public class chengyou_lc763 {
    int[] lastSeen = new int[26];
        for (int i = 0; i < S.length(); i++)
    lastSeen[S.charAt(i) - 'a'] = i;
    int start = 0, end = 0;
    List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
        end = Math.max(end, lastSeen[S.charAt(i) - 'a']);
        if (i == end) {
            res.add(i - start + 1);
            start = i + 1;
        }
    }
        return res;
}