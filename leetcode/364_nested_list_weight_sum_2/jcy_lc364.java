public class jcy_lc364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList(nestedList);
        int prev = 0, res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.poll();
                if (curr.isInteger()) prev += curr.getInteger();
                else queue.addAll(curr.getList());
            }
            res += prev;
        }
        return res;
    }
}