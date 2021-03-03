import java.util.Stack;

public class jcy_lc402 {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char n : num.toCharArray()) {
            while (!stack.empty() && k > 0 && n < stack.peek()) {
                stack.pop();
                k -= 1;
            }
            stack.push(n);
        }
        for (int i = 0; i < k; i++) stack.pop();
        if (stack.size() == 0) return "0";
        char[] res = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) res[i] = stack.pop();
        int idx = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != '0') {
                idx = i;
                break;
            }
        }
        if (idx == 0 && res[idx] == '0') return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < res.length; i++) sb.append(res[i]);
        return sb.toString();
    }
}