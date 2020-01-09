import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class wsz_java_282 {
    private Map<String,List<String>> memory = new HashMap<>();

    public List<String> addOperators(String num, int target) {
        List<String> result = search(num, 0, target);
        return result;
    }

    private List<String> search(String num, int index, int target) {
        String token = index + " " + target;
        if (memory.containsKey(token)) {
            return memory.get(token);
        }
        if (index == num.length()) {
            List<String> empty = new ArrayList<>();
            if (target == 0){
                empty.add("");
            }
            return empty;
        }
        int partial = 0;
        List<String> result = new ArrayList<>();
        for (int i=index; i<num.length(); i++) {
            partial = partial*10 + (num.charAt(index) - '0');
            List<String> tails = search(num, i+1, target-partial);
            for (String tail : tails) {
                result.add(partial + tail);
            }
            if (num.charAt(index) == '0') {
                break;
            }
        }
        memory.put(token, result);
        return result;
    }
}
