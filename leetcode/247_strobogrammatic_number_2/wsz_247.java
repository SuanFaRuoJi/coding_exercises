import java.util.ArrayList;
import java.util.List;

public class wsz_247 {
    private List<String> one = new ArrayList<>();
    {
        one.add("0");
        one.add("1");
        one.add("8");
    }
    private List<String> two_all = new ArrayList<>();
    {
        two_all.add("11");
        two_all.add("69");
        two_all.add("96");
        two_all.add("88");
        two_all.add("00");
    }
    private List<String> two = new ArrayList<>();
    {
        two.add("11");
        two.add("69");
        two.add("96");
        two.add("88");
    }

    public List<String> findStrobogrammatic(int n) {
        return search(n, true);
    }

    private List<String> search(int n, boolean out) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return one;
        }
        if (n == 2) {
            return out ? two : two_all;
        }
        List<String> inner = search(n - 2, false);
        List<String> result = new ArrayList<>();
        for (String cur : inner) {
            result.add("1" + cur + "1");
            result.add("6" + cur + "9");
            result.add("9" + cur + "6");
            result.add("8" + cur + "8");
            if (!out) {
                result.add("0" + cur + "0");
            }
        }
        return result;
    }
}
