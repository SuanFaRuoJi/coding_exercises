public class jcy_lc1668 {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        String curr = new String(word);
        while (sequence.contains(curr)) {
            res += 1;
            curr = curr.concat(word);
        }
        return res;
    }
}