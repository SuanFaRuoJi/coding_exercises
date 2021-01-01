import java.util.ArrayList;
import java.util.List;

public class jcy_lc89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) res.add(i ^ (i >> 1));
        return res;
    }
}