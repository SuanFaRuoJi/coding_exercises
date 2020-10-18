import java.util.*;

public class jcy_1081 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            lastSeen.put(s.charAt(i), i);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.empty() && c < stack.peek() && lastSeen.get(stack.peek()) > i)
                    seen.remove(stack.pop());
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) sb.append(c.charValue());
        return sb.toString();
    }
}