public class jcy_lc339_bfs {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger n : nestedList) queue.add(n);
        int depth = 1, res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.poll();
                if (curr.isInteger())
                    res += curr.getInteger() * depth;
                else {
                    for (NestedInteger n : curr.getList())
                        queue.add(n);
                }
            }
            depth += 1;
        }
        return res;
    }
}