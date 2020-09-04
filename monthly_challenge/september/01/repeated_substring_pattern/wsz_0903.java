import java.util.ArrayList;
import java.util.List;

public class wsz_0903 {
    public boolean repeatedSubstringPattern(String s) {
        List<Integer> distinct = new ArrayList<>();
        int[] histo = new int[26];
        char[] s_char = s.toCharArray();
        for (int i=0; i<s_char.length; i++) {
            int index = s_char[i] - 'a';
            if (histo[index]++ == 0) {
                distinct.add(index);
            }
        }
        int base_length = -1;
        for (int i=0; i<distinct.size(); i++) {
            if (base_length == -1) {
                base_length = gcd(s_char.length, histo[distinct.get(i)]);
            } else {
                base_length = gcd(base_length, histo[distinct.get(i)]);
            }
            if (base_length == 1) {
                return false;
            }
        }

        base_length = s_char.length / base_length;

        int cur_length = base_length;
        while (cur_length < s_char.length) {
            System.out.println(cur_length);
            int repeat = s_char.length / cur_length;
            if (repeat * cur_length == s_char.length) {
                boolean satisfy = true;
                for (int i=cur_length; i<s_char.length; i++) {
                    int first = i % cur_length;
                    if (s_char[first] != s_char[i]) {
                        satisfy = false;
                        break;
                    }
                }
                if (satisfy) {
                    return true;
                }
            }
            cur_length += base_length;
        }
        return false;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        if (a < b) {
            return gcd(b, a);
        }
        return gcd(b, a%b);
    }
}
