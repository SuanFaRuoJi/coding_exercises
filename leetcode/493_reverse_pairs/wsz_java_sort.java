public class wsz_java_sort {
    public int reversePairs(int[] nums){
        return merge(nums, 0, nums.length-1);
    }

    int merge(int[] nums, int l, int r){
        int length = r-l+1;
        if (length <= 1){
            return 0;
        }
        int mid = (l+r)/2, result = 0;
        int l_result = merge(nums, l, mid);
        int r_result = merge(nums, mid+1, r);
        int[] tmp = new int[length];
        int l_it = l, r_it = mid+1, tmp_index = 0;
        // first calculate
//System.out.println(l + " " + r);
        for (; l_it <= mid; l_it++){
            while(r_it <= r){
                long target = (long)nums[r_it]*2;
                if (target >= nums[l_it]){
                    break;
                }
                r_it ++;
            }
            result += r_it - (mid+1);
        }
//System.out.println("calculated");
        // then merge
        l_it = l;
        r_it = mid+1;
        while(l_it <= mid || r_it <= r){
            while (l_it <= mid && (r_it > r || nums[l_it] < nums[r_it])){
                tmp[tmp_index] = nums[l_it];
                l_it ++;
                tmp_index ++;
            }
            while (r_it <= r && (l_it > mid || nums[r_it] <= nums[l_it])){
                tmp[tmp_index] = nums[r_it];
                r_it ++;
                tmp_index ++;
            }
        }
//System.out.println("Merged");
        System.arraycopy(tmp, 0, nums, l, length);
        return l_result + r_result + result;
    }
}
