import java.util.*;

public class jcy_lc1157 {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] nums;

    public jcy_lc1157(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        this.nums = arr;
    }

    public int query(int left, int right, int threshold) {
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int randIdx = rand.nextInt(right - left + 1) + left;
            int cur = this.nums[randIdx];
            int lowIdx = searchLowestIndex(map.get(cur), left);
            int highIdx = searchHighestIndex(map.get(cur), right);
            if (highIdx - lowIdx + 1 >= threshold)
                return cur;
        }
        return -1;
    }

    private int searchLowestIndex(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int searchHighestIndex(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left - 1;
    }
}