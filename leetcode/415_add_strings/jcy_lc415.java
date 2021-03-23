public class jcy_lc415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int x1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int x2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int val = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            sb.append(val);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}