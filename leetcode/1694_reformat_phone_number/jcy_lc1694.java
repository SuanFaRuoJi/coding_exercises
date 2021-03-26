public class jcy_lc1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int counter = 0, n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == ' ' || number.charAt(i) == '-') continue;
            sb.append(number.charAt(i));
            counter += 1;
            if (counter == 3) {
                counter = 0;
                sb.append('-');
            }
        }
        if (counter == 1 && n > 1) {
            sb.insert(sb.length() - 3, '-');
            sb.deleteCharAt(sb.length() - 2);
        }
        if (sb.charAt(sb.length() - 1) == '-') sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}