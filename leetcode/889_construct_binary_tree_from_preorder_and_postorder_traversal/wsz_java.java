public class wsz_java {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length, size = 0;
        if (length == 0){
            return null;
        }
        int[][] coor = new int[length+1][2];
        for (int i=0; i<length; i++){
            coor[pre[i]][0] = i;
            coor[post[i]][1] = i;
        }
        TreeNode[] stack = new TreeNode[length];
        int[] cross = new int[length+1];
        TreeNode root = new TreeNode(pre[0]);
        stack[size++] = root;
        while(size != 0){
            TreeNode cur = stack[--size];
            int left_most = coor[cur.val][0] + 1;
            if (left_most < length && cross[pre[left_most]] == 0){
                cross[pre[left_most]] = 1;
                TreeNode toAdd = new TreeNode(pre[left_most]);
                stack[size++] = toAdd;
                cur.left = toAdd;
            }
            int right_most = coor[cur.val][1] - 1;
            if (right_most >= 0 && cross[post[right_most]] == 0){
                cross[post[right_most]] = 1;
                TreeNode toAdd = new TreeNode(post[right_most]);
                stack[size++] = toAdd;
                cur.right = toAdd;
            }
        }
        return root;
    }
}
