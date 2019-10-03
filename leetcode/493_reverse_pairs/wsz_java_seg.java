public class wsz_java_seg {
    class SegNode {
        double l, r;
        SegNode l_node, r_node;
        int count;

        SegNode(double l_bound, double r_bound){
            count = 0;
            l = l_bound;
            r = r_bound;
        }

        void add(double val){
            //System.out.println("add: " + l + " " + r);
            if (l > val || r < val){
                return;
            }
            count ++;
            if (l == r){
                //System.out.println(l + " " + r + " added: " + val);
                return;
            }
            double mid = Math.floor((l+r)/2);
            if (l_node == null){
                l_node = new SegNode(l, mid);
            }
            l_node.add(val);
            if (r_node == null){
                r_node = new SegNode(mid+1, r);
            }
            r_node.add(val);
        }

        int find(double l_bound, double r_bound){
            //System.out.println("find: " + l + " " + r);
            if (r_bound < l_bound){
                return 0;
            }
            if (l >= l_bound && r <= r_bound){
                return count;
            }
            if (l > r_bound || r < l_bound){
                return 0;
            }
            return (l_node == null ? 0 : l_node.find(l_bound, r_bound)) + (r_node == null ? 0 : r_node.find(l_bound, r_bound));
        }
    }

    public int reversePairs(int[] nums){
        int l = nums.length;
        if (l <= 1){
            return 0;
        }
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<l; i++){
            if (nums[i] < min){
                min = nums[i];
            }
            if (nums[i] > max){
                max = nums[i];
            }
        }
        //System.out.println(min + " " + max);
        SegNode tree = new SegNode(min*2, max*2);
        int sum = 0;
        for (int i=l-1; i>=0; i--){
            double target = ((double)nums[i]);
            //System.out.println("range: " + min*2 + ", " + (target-1));
            sum += tree.find(min*2, target-1);
            //System.out.println("sum: " + sum + " for target: " + target);
            tree.add(target*2);
        }
        return sum;
    }

}
