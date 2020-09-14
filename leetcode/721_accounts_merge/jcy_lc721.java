import java.util.*;

public class jcy_lc721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                map.put(account.get(i), userName);
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        for (String email : map.keySet()) {
            List<String> list = new ArrayList<>();
            if (!visited.contains(email)) {
                visited.add(email);
                Stack<String> stack = new Stack<>();
                stack.push(email);
                while (!stack.empty()) {
                    String curr = stack.pop();
                    list.add(curr);
                    for (String next : graph.get(curr)) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            stack.push(next);
                        }
                    }
                }
                Collections.sort(list);
                list.add(0, map.get(email));
                res.add(list);
            }
        }
        return res;
    }
}