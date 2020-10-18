import java.util.Stack;

public class jcy_lc316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        int[] lastSeen = new int[26];
        for (int i = 0; i < s.length(); i++)
            lastSeen[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a'] == false) {
                while (!stack.empty() && c < stack.peek() && lastSeen[stack.peek() - 'a'] > i)
                    seen[stack.pop() - 'a'] = false;
                seen[c - 'a'] = true;
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}