import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class wsz_726 {
    public String countOfAtoms(String formula) {
        int[] stack = new int[formula.length()];
        int top = 0, cache = 0, i = formula.length()-1, product = 1, exponent = 0;
        Map<String, Integer> count = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            char cur = formula.charAt(i);
            if (cur == ')') {
                int actual = cache == 0 ? 1 : cache;
                product = product * actual;
                stack[top++] = actual;
                cache = 0;
                exponent = 0;
            } else if (cur == '(') {
                top --;
                product = product / stack[top];
            } else if ('0' <= cur && cur <= '9') {
                cache = cache + (int)Math.pow(10, exponent) * (cur - '0');
                exponent++;
            } else {
                sb.append(cur);
                if ('A' <= cur && cur <= 'Z') {
                    String to_put = sb.reverse().toString();
                    count.put(to_put, count.getOrDefault(to_put, 0) + product * (cache == 0 ? 1 : cache));
                    sb = new StringBuilder();
                    cache = 0;
                    exponent = 0;
                }
            }
            i--;
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() != 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }
}
