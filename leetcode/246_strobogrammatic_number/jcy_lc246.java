import java.util.HashSet;
import java.util.Set;

public class jcy_lc246 {
    public boolean isStrobogrammatic(String num) {
        Set<String> set = new HashSet<>();
        set.add("00");
        set.add("11");
        set.add("88");
        set.add("69");
        set.add("96");
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            if (!set.contains(num.charAt(left) + "" + num.charAt(right)))
                return false;
            left += 1; right -= 1;
        }
        return true;
    }
}