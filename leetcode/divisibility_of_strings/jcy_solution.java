public class jcy_solution {
    public static int getLength(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen % tLen != 0) return -1;
        StringBuilder sb = new StringBuilder();
        if (!checkSubstring(s, t)) return -1;
        for (int i = 0; i < tLen; i++) {
            if (checkSubstring(t, t.substring(0, i + 1)))
                return i + 1;
        }
        return -1;
    }

    private static boolean checkSubstring(String s, String t) {
        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i % t.length())) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bcdbcdbcdbcd", t = "bcdbcd";
        System.out.println(getLength(s, t));
    }
}