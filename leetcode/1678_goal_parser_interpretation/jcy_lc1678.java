public class jcy_lc1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') sb.append('G');
            else if (i + 1 < command.length() && command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 1;
            }
            else if (i + 1 < command.length() && command.charAt(i) == '(' && command.charAt(i + 1) == 'a') {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}