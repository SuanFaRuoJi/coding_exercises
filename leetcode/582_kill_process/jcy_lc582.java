import java.util.*;

public class jcy_lc582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.size() > 0) {
                map.putIfAbsent(ppid.get(i), new HashSet<>());
                map.get(ppid.get(i)).add(pid.get(i));
            }
        }
        queue.add(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (map.containsKey(curr)) {
                for (int p : map.get(curr)) queue.add(p);
            }
            res.add(curr);
        }
        return res;
    }
}