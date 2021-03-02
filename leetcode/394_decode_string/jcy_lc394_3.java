public class jcy_lc394_3 {
    int idx = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (idx < s.length() && s.charAt(idx) != ']') {
            if (!Character.isDigit(s.charAt(idx))) sb.append(s.charAt(idx++));
            else {
                int k = 0;
                while (idx < s.length() && Character.isDigit(s.charAt(idx)))
                    k = k * 10 + s.charAt(idx++) - '0';
                idx += 1;
                String decoded = decodeString(s);
                idx += 1;
                while (k-- > 0) sb.append(decoded);
            }
        }
        return new String(sb);
    }
}