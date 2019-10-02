import java.util.*;

public class wsz_java_315 {
    public List<Integer> countSmaller(int[] nums) {
        int l = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i<l; i++){
            if (nums[i] > max){
                max = nums[i];
            }
            if (nums[i] < min){
                min = nums[i];
            }
        }
        int bush_size = max-min+1;
        int[] tree = new int[bush_size];
        Integer[] raw_result = new Integer[l];
        for (int i=l-1; i>=0; i--){
            int cur = nums[i] - min + 1;
            raw_result[i] = find(tree, cur-1); // return evrything <= cur - 1, equivalent to everything < cur in Integer.
            update(tree, cur);
        }
        return Arrays.asList(raw_result);
    }

    public void update(int[] arr, int key){
        while(key < arr.length){
            arr[key] ++;
            key += key & (-key);
        }
    }

    public int find(int[] arr, int key){
        int sum = 0;
        while(key > 0){
            sum += arr[key];
            key -= key & (-key);
        }
        return sum;
    }
}
