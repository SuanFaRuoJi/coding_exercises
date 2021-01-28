import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class jcy_lc433 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        int res = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) return res;
                char[] curCharArr = cur.toCharArray();
                for (int i = 0; i < curCharArr.length; i++) {
                    char prev = curCharArr[i];
                    for (char c : choices) {
                        if (prev == c) continue;
                        curCharArr[i] = c;
                        String next = new String(curCharArr);
                        if (!visited.contains(next) && set.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curCharArr[i] = prev;
                }
            }
            res += 1;
        }
        return -1;
    }
}