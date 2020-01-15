public class wsz_java_302 {
    public int minArea(char[][] image, int x, int y) {
        if (image.length == 0) {
            return 0;
        }
        return (Math.abs(binary_search(image, x, true, true) - binary_search(image, x, false, true))+1) *
                (Math.abs(binary_search(image, y, true, false) - binary_search(image, y, false, false))+1);
    }

    private int binary_search(char[][] image, int mid, boolean inc, boolean x) {
        int a = inc ? mid : 0,
                b = inc ? (x ? image.length-1 : image[0].length-1) : mid;
        if (inc && check(image, b, x)) {
            //System.out.println("Finished: " + a + " " + b);
            return b;
        }
        if (!inc && check(image, a, x)) {
            //System.out.println("Finished: " + a + " " + b);
            return a;
        }
        while (a+1 < b) {
            //System.out.println(a + " " + b);
            int mid_ = (a+b)/2;
            if (check(image, mid_, x)) {
                if (inc) {
                    a = mid_;
                } else {
                    b = mid_;
                }
            } else {
                if (inc) {
                    b = mid_;
                } else {
                    a = mid_;
                }
            }
        }
        //System.out.println("Finished: " + a + " " + b);
        return inc ? a : b;
    }

    private boolean check(char[][] image, int index, boolean x) {
        for (int i=0; i< (x ? image[0].length : image.length); i++) {
            if (x) {
                if (image[index][i] == '1') {
                    return true;
                }
            } else {
                if (image[i][index] == '1') {
                    return true;
                }
            }
        }
        return false;
    }
}
