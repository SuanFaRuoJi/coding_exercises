public class wsz_0901_1 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */

    public int read(char[] buf, int n) {
        int index = 0;
        char[] carrier = new char[4];
        while (index < n) {
            int length = read4(carrier);
            int actual = Math.min(n - index, length);
            System.arraycopy(carrier, 0, buf, index, actual);
            index += actual;
            if (actual == 0) {
                break;
            }
        }
        return index;
    }
    private int read4(char[] buf) {return 0;}
}
