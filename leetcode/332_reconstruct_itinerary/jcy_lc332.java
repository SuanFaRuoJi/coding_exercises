import java.util.*;

public class jcy_lc332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        stack.push("JFK");
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty())
                stack.push(map.get(stack.peek()).poll());
            res.add(0, stack.pop());
        }
        return res;
    }
}