import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lc_271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder metadata = new StringBuilder();
        metadata.append(strs.size());
        metadata.append(' ');
        StringBuilder content = new StringBuilder();
        for (String str : strs) {
             metadata.append(str.length());
             metadata.append(' ');
             content.append(str);
        }
        StringBuilder result = new StringBuilder();
        result.append(metadata).append(content);
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, num = 0;
        List<String> result = new ArrayList<>();
        while(i < s.length() && s.charAt(i) != ' ') {
            num = num*10 + (s.charAt(i)-'0');
            i++;
        }
        if (num == 0) {
            return result;
        }
        int[] lengths = new int[num];
        for (int index=0; index<num; index++) {
            int length = 0;
            i++;
            while(i < s.length() || s.charAt(i) != ' ') {
                length = length*10 + (s.charAt(i) - '0');
                i++;
            }
            lengths[index] = length;
        }
        i++;
        for (int index=0; index<num; index++) {
            int length = lengths[index], count = 0;
            StringBuilder cur = new StringBuilder();
            for (int head = 0; head < length; head++, i++) {
                cur.append(s.charAt(i));
            }
            result.add(cur.toString());
        }
        return result;
    }
}
