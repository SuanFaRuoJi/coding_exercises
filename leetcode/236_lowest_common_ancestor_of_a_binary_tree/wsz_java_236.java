class wsz_java_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] stack = new TreeNode[20000];
        int[] stack_l = new int[20000];
        TreeNode cur = root;
        int level = 0, size = 0;
        while(cur != null){
            stack[size] = cur;
            stack_l[size] = level;
            cur = cur.left;
            level ++;
            size ++;
        }
        int meet = 0, min_level = Integer.MAX_VALUE;
        TreeNode min_node = null;
        while(size != 0){
            cur = stack[size-1];
            int cur_val = cur.val, cur_level = stack_l[size-1];
            if (cur_val == p.val || cur_val == q.val){
                meet ++;
            }
            if (meet >= 1){
                if (cur_level < min_level){
                    min_level = cur_level;
                    min_node = cur;
                }
            }
            if (meet >= 2){
                return min_node;
            }
            size --;
            TreeNode to_add = cur.right;
            int to_level = cur_level + 1;
            while(to_add != null){
                stack[size] = to_add;
                stack_l[size] = to_level;
                to_add = to_add.left;
                to_level ++;
                size ++;
            }
        }
        return null;
    }
}