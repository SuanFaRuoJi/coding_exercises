import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc_726 {
    int cursor;
    String _formula;

    public String countOfAtoms(String formula) {
        cursor = 0;
        _formula = formula;
        HashMap<String, Integer> result = consumeFormula(_formula.length());
        List<String> keys = new ArrayList<>();
        keys.addAll(result.keySet());
        keys.sort(String::compareTo);
        StringBuilder string_result = new StringBuilder();
        for (String key : keys) {
            string_result.append(key);
            string_result.append(result.get(key));
        }
        return string_result.toString();
    }

    private String consumeElement() {
        StringBuilder result = new StringBuilder();
        result.append(_formula.charAt(cursor++));
        while (cursor < _formula.length() && Character.isLowerCase(_formula.charAt(cursor))) {
            result.append(_formula.charAt(cursor));
            cursor++;
        }
        return result.toString();
    }

    private int consumeNumber() {
        StringBuilder result = new StringBuilder();
        while (cursor < _formula.length() && Character.isDigit(_formula.charAt(cursor))) {
            result.append(_formula.charAt(cursor));
            cursor++;
        }
        return result.length()==0 ? 1 : Integer.parseInt(result.toString());
    }

    private HashMap<String, Integer> consumeFormula(int to) {
        HashMap<String, Integer> result = new HashMap<>();
        while (cursor < to) {
            char cur = _formula.charAt(cursor);
            if (cur == '(') {
                int end = close_bracket(cursor); // the )
                cursor ++;
                HashMap<String, Integer> part = consumeFormula(end);
                cursor = end + 1;
                by(part, consumeNumber());
                merge(result, part);
                continue;
            }
            if (Character.isAlphabetic(cur)) {
                String element = consumeElement();
                int occurrence = consumeNumber();
                result.compute(element, (k, v) -> v==null ? occurrence : v+occurrence);
                continue;
            }
        }
        return result;
    }

    private int close_bracket(int start) {
        int stack = 1, local_cursor = start+1;
        while (stack != 0) {
            char cur = _formula.charAt(local_cursor);
            if (cur == '(') {
                stack++;
            }
            if (cur == ')') {
                stack--;
                if (stack == 0) {
                    return local_cursor;
                }
            }
            local_cursor++;
        }
        return local_cursor;
    }

    private void merge(Map<String, Integer> a, Map<String, Integer> b) {
        for (Map.Entry<String, Integer> entry : b.entrySet()) {
            a.compute(entry.getKey(), (k, v) -> v==null ? entry.getValue() : v+entry.getValue());
        }
    }

    private void by(Map<String, Integer> a, int multiplier) {
        List<String> keys = new ArrayList<>();
        keys.addAll(a.keySet());
        for (String key : keys) {
            a.compute(key, (k, v) -> v*multiplier);
        }
    }
}
