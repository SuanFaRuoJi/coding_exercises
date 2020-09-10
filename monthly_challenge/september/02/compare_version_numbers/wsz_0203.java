public class wsz_0203 {
    public int compareVersion(String version1, String version2) {
        char[] v1 = version1.toCharArray(), v2 = version2.toCharArray();
        int i = 0, j = 0;
        while (i < v1.length || j < v2.length) {
            int v1_cur = 0, v2_cur = 0;
            while (i < v1.length && v1[i] != '.') {
                v1_cur = v1_cur * 10 + (v1[i] - '0');
                i++;
            }
            i++;
            while (j < v2.length && v2[j] != '.') {
                v2_cur = v2_cur * 10 + (v2[j] - '0');
                j++;
            }
            j++;
            if (v1_cur < v2_cur) {
                return -1;
            }
            if (v1_cur > v2_cur) {
                return 1;
            }
        }
        return 0;
    }
}
