import java.util.ArrayDeque;
import java.util.Deque;

public class jcy_lc71 {
    public String simplifyPath(String path) {
        Deque<String> dq = new ArrayDeque<>();
        String[] s = path.split("/");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("") || s[i].equals(".")) continue;
            else if (s[i].equals("..")) {
                if (!dq.isEmpty()) dq.removeLast();
                else continue;
            }
            else dq.addLast(s[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!dq.isEmpty()) {
            sb.append(dq.removeFirst());
            if (dq.size() != 0) sb.append("/");
        }
        return sb.toString();
    }
}