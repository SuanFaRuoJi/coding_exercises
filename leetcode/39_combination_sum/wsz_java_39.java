class wsz_java_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[][] dp = new List[candidates.length][target+1];
        for (int i=0; i<candidates.length; i++) {
            List<Integer> to_add = new ArrayList<>();
            List<List<Integer>> dummy = new ArrayList<>();
            dummy.add(to_add);
            dp[0][i] = dummy;
        }
        for (int i=1; i<=target; i++) {
            for (int j=0; j<candidates.length; j++) {
                int cur = candidates[j];
                List<List<Integer>> result = new ArrayList<>();
                if (j != 0) {
                    result.addAll(dp[i][j-1]);
                }
                if (cur <= i) {
                    List<List<Integer>> prev = dp[i-cur][j];
                    for (List<Integer> chain : prev) {
                        List<Integer> new_chain = new ArrayList<>();
                        new_chain.addAll(chain);
                        new_chain.add(cur);
                        result.add(new_chain);
                    }
                }
                dp[i][j] = result;
            }
        }
        return dp[candidates.length-1][target];
    }
}