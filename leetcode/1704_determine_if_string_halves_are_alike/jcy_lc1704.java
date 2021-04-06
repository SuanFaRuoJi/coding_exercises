import java.util.HashSet;
import java.util.Set;

public class jcy_lc1704 {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length() / 2; i++)
            if (vowels.contains(s.charAt(i))) cnt1 += 1;
        for (int i = s.length() / 2; i < s.length(); i++)
            if (vowels.contains(s.charAt(i))) cnt2 += 1;
        return cnt1 == cnt2;
    }
}