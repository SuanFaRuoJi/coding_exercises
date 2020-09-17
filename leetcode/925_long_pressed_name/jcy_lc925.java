public class jcy_lc925 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j))
                i += 1;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
            j += 1;
        }
        return i == name.length();
    }
}