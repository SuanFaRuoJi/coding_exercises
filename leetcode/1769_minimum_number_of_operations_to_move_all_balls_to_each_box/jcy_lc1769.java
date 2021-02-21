public class jcy_lc1769 {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        int moves = 0, count = 0;
        for (int i = 0; i < boxes.length(); i++) {
            res[i] += moves;
            if (boxes.charAt(i) == '1') count += 1;
            moves += count;
        }
        moves = 0; count = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            res[i] += moves;
            if (boxes.charAt(i) == '1') count += 1;
            moves += count;
        }
        return res;
    }
}