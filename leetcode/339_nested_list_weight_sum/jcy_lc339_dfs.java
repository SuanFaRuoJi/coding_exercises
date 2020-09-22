public class jcy_lc339_dfs {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
        int res = 0;
        for (NestedInteger n : list) {
            if (n.isInteger()) res += n.getInteger() * depth;
            else res += helper(n.getList(), depth + 1);
        }
        return res;
    }
}