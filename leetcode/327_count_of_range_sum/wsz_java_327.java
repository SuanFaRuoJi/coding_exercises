import java.util.List;

public class wsz_java_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int l = nums.length, sum = 0;
        if (l <= 1){
            return (l==1 && nums[0]<=upper && nums[0]>=lower) ? 1 : 0;  //if le one number, handle directly.
        }
        for (int i=0; i<l; i++){
            sum += nums[i];
            nums[i] = sum;
        }
        return merge(nums, lower, upper, 0, l-1);
    }

    int merge(int[] prefix_sums, int lower, int upper, int l, int r){
        /*
        * Define a mid between l, r
        * After the subroutines return, the items in prefix_sums will be partially, i.e.
        * [i, mid], [mid+1, r] sorted. Then do merge, as well as the following:
        * l_result, r_result, find all pairs [a, b] where a in r_result, b in l_result and a-b in [lower, upper]
        * return this count, then add with l_count + r_count.
        * */
        int length = r - l + 1, mid = (l+r)/2;
        if (length == 1){
            return (prefix_sums[l]<=upper && prefix_sums[l]>=lower) ? 1 : 0;
        }
        int l_result = merge(prefix_sums, lower, upper, l, mid);
        int r_result = merge(prefix_sums, lower, upper, mid+1, r);
        int result = 0;
        int[] tmp = new int[length];
        int l_it = l, r_it = r;
        /*
        * TODO: write the method that sweeps twice(l->mid, r->mid+1 and mid->l, mid+1->r) to determine the interval, then do
        *  the multiplication to calculate the cross pairs that satisfy.
        * */
        while (l_it <= mid || r_it >= mid+1){

        }
        l_it = l;
        r_it = mid+1;
        int index = 0;
        while(l_it <= mid || r_it <= r){
            while(l_it <= mid && (r_it > r || prefix_sums[l_it] < prefix_sums[r_it])){
                tmp[index] = prefix_sums[l_it];
                l_it ++;
                index ++;
            }
            while(r_it <= r && (l_it > mid || prefix_sums[r_it] < prefix_sums[l_it])){
                tmp[index] = prefix_sums[r_it];
                r_it ++;
                index ++;
            }
        }
        System.arraycopy(tmp, 0, prefix_sums, l, length);
        return l_result + r_result  + result;
    }
}
