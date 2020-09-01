public class jcy_lc1328 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        char[] S = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (S[i] != 'a') {
                S[i] = 'a';
                return String.valueOf(S);
            }
        }
        S[n - 1] = 'b';
        return String.valueOf(S);
    }
}