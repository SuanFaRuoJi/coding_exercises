public class chengyou_lc443 {
    public int compress(char[] chars) {
        int i = 0, res = 0;
        while (i < chars.length) {
            char cur = chars[i];
            int cnt = 0;
            while (i < chars.length && chars[i] == cur) {
                i += 1; cnt += 1;
            }
            chars[res] = cur; res += 1;
            if (cnt != 1) {
                for (char c : Integer.toString(cnt).toCharArray()) {
                    chars[res] = c; res += 1;
                }
            }
        }
        return res;
    }
}
