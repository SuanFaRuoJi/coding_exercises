public class wsz_227 {
    private String raw;
    private int needle = 0;

    public int calculate(String s) {
        raw = s;
        int acc = 0;
        char prev = ' ';
        while (needle < raw.length()) {
            int local = consume_number();
            char op = consume_operator();
            while (op == '*' || op == '/') {
                local = op == '*' ? (local * consume_number()) : (local / consume_number());
                op = consume_operator();
            }
            if (prev == ' ' || prev == '+') {
                acc += local;
            } else {
                acc -= local;
            }
            prev = op;
        }
        return acc;
    }

    private int consume_number() {
        int acc = 0;
        boolean met = false;
        while (needle < raw.length()) {
            char cur = raw.charAt(needle);
            if (cur > '9' || cur < '0') {
                if (met) {
                    System.out.println(acc);
                    return acc;
                }
            } else {
                acc = acc * 10 + (cur - '0');
                met = true;
            }
            needle ++;
        }
        return acc;
    }

    private char consume_operator() {
        while (needle < raw.length()) {
            if (raw.charAt(needle) != ' ') {
                System.out.println(raw.charAt(needle));
                return raw.charAt(needle);
            }
            needle ++;
        }
        return ' ';
    }
}
