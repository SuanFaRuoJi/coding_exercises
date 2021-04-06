import java.util.HashSet;
import java.util.Set;

public class jcy_lc1805 {
    public int numDifferentIntegers(String word) {
        Set<Double> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            if (Character.isDigit(word.charAt(i))) {
                while (i < word.length() && Character.isDigit(word.charAt(i)))
                    sb.append(word.charAt(i++));
                set.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
            }
        }
        return set.size();
    }
}