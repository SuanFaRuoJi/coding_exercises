import java.util.ArrayList;

public class lc_1055 {
    public int shortestWay(String source, String target) {
        ArrayList<Integer>[] indices = new ArrayList[26];
        int l_source = source.length(), l_target = source.length();
        for (int i=0; i<l_source; i++) {
            int cur = source.charAt(i) - 'a';
            if (indices[cur] == null) {
                indices[cur] = new ArrayList<>();
            }
            indices[cur].add(i);
        }
        int count = 0, head = 0;
        int[] left = new int[26] ;
        for (int i=0; i<l_target; i++) {
            int cur = target.charAt(i) - 'a';
            int l = left[cur] + 1;
            if (indices[cur] == null) {
                return -1;
            }
            int index = binary(indices[cur], l, head);
            if (index == -1) {
                count ++;
                left = new int[26];
                head = 0;
                index = binary(indices[cur], 0, head );
            }
            head = index;
            left[cur] = index;
        }
        return count;
    }

    private int binary(ArrayList<Integer> arr, int l, int i) {
        int r = arr.size()-1;
        if (i > arr.get(r) || l >= r) {
            return -1;
        }
        if (i <= arr.get(l)) {
            return l;
        }
        while (l+1 < r) {
            int mid = (l+r)/2;
            if (arr.get(mid) < i) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return r;
    }
}
