public class wsz_java{
	int min = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s){
        char[] arr = s.toCharArray(), seed = Arrays.copyOf(arr, arr.length+2);
        int l = arr.length;
        seed[l] = 0;
        seed[l+1] = 0;
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        ArrayList<char[]> q = new ArrayList<>();
        q.add(seed);
        int index=0;
        while(index < q.size()){
            char[] cur = q.get(index);
            index ++;
            if (validate(cur)){
                min = cur[l+1];
                result.add(stringify(cur));
            }else{
                if (cur[l+1] > min){
                    break;
                }
                for (int i=cur[l]; i<l; ){
                    char cur_char = cur[i];
                    if (cur_char == '(' || cur_char == ')'){
                        cur[i] = ' ';
                        char[] toAdd = Arrays.copyOf(cur, l+2);
                        toAdd[l] = (char)i;
                        toAdd[l+1] = (char)(cur[l+1]+1);
                        q.add(toAdd);
                        cur[i] = cur_char;
                    }
                    while(i<l && cur[i] == cur_char){
                        i++;
                    }
                }
            }
        }
        return result;
    }

    private String stringify(char[] s){
        String result = "";
        for (int i=0; i<s.length-2; i++){
            char cur = s[i];
            if (cur != ' '){
                result += cur;
            }
        }
        return result;
    }

    private boolean validate(char[] s){
        int l = s.length;
        if (l == 0)
            return true;
        int count = 0;
        for (int i=0; i<l; i++){
            char cur = s[i];
            if (cur == '('){
                count ++;
            }
            if (cur == ')'){
                count --;
            }
            if (count < 0){
                return false;
            }
        }
        return count==0;
    }
}
