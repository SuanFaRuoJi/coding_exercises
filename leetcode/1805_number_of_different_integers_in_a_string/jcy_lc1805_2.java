import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class jcy_lc1805_2 {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        set.add("");
        int i = 0;
        for (int j = 0; j < word.length(); j++) {
            if (Character.isDigit(word.charAt(j)))
                i += i < j && word.charAt(i) == '0' ? 1 : 0;
            else {
                set.add(word.substring(i, j));
                i = j + 1;
            }
        }
        set.add(word.substring(i));
        return set.size() - 1;
    }
}