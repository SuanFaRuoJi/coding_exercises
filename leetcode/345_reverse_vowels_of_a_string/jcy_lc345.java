public class jcy_lc345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (isVowel(arr[i]) && isVowel(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i += 1; j -= 1;
            } else {
                if (!isVowel(arr[i])) i += 1;
                if (!isVowel(arr[j])) j -= 1;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(Character c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        else return false;
    }
}