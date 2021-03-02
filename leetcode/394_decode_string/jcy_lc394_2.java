import java.util.Stack;

public class jcy_lc394_2 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curStr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) k = k * 10 + c - '0';
            else if (c == '[') {
                countStack.push(k);
                stringStack.push(curStr);
                curStr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decoded = stringStack.pop();
                for (int curK = countStack.pop(); curK > 0; curK--)
                    decoded.append(curStr);
                curStr = decoded;
            } else curStr.append(c);
        }
        return curStr.toString();
    }
}