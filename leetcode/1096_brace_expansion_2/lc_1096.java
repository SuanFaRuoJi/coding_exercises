import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc_1096 {
    public List<String> braceExpansionII(String expression) {
        Set<String> set_result = parse(expression, 0, expression.length()-1);
        List<String> result = new ArrayList<>(set_result);
        result.sort(String::compareTo);
        return result;
    }

    /**
     * Do the parsing backward to ensure order
     * @param expression the expression to be parsed
     * @param start the starting point of current parse (inclusive
     * @param end the end point of cureent parse (inclusive
     * @return the parsed list of words from start to end
     */
    private Set<String> parse(String expression, int start, int end) {
        int i = end;
        Set<String> result = new HashSet<>();
        StringBuilder word = new StringBuilder();
        while (i >= start) {
            char cur = expression.charAt(i);
            if (cur == ',') {
                if (word.length() != 0) {
                    result.add(word.toString());
                }
                Set<String> next = parse(expression, start, i-1);
                result.addAll(next);
                return result;
            } else {
                if (cur == '}') {
                    if (word.length() != 0) {
                        result.add(word.toString());
                    }
                    word = new StringBuilder();
                    int bracket = close_bracket(expression, i);
                    Set<String> next = parse(expression, bracket+2, i-1);
                    result = result.isEmpty() ? next : product(next, result);
                    i = bracket;
                } else {
                    word.insert(0, cur);
                    i --;
                }
            }
        }
        if (word.length() != 0) {
            result.add(word.toString());
        }
        return result;
    }

    private Set<String> product(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();
        for (String a_cur : a) {
            for (String b_cur : b) {
                result.add(a_cur+b_cur);
            }
        }
        return result;
    }

    private int close_bracket(String expression, int end) {
        int i = end, count = 0;
        do {
            char cur = expression.charAt(i);
            if (cur == '}') {
                count ++;
            }
            if (cur == '{') {
                count --;
            }
            i --;
        } while (count != 0);
        return i;
    }
}
