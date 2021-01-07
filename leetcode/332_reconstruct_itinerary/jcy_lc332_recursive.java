import java.util.*;

public class jcy_lc332_recursive {
    LinkedList<String> res = new LinkedList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        helper("JFK");
        return res;
    }

    private void helper(String s) {
        PriorityQueue<String> pq = map.get(s);
        while (pq != null && !pq.isEmpty()) helper(pq.poll());
        res.addFirst(s);
    }
}