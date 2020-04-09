public class RangeModule {
    private Segment top_interval;

    class Segment {
        int left;
        int right;
        Segment left_child;
        Segment right_child;
        boolean covered = false;

        Segment() {
            left_child = null;
            right_child = null;
        }

        void add(int left_, int right_, boolean carry) {
            /*
            if (left_ <= left && right_ >= right) {
                System.out.println(left + ", " + right + ": " + carry);
            }
            */
            if (left_ <= left && right_ >= right) {
                covered = carry;
                left_child = null;
                right_child = null;
                return;
            }
            if (left_ >= right || right_ <= left) {
                return;
            }
            if (right - left <= 1) { // leaf
                return;
            }
            int mid = (left + right) / 2;
            if (left < mid) {
                if (left_child == null) {
                    left_child = new Segment();
                    left_child.left = left;
                    left_child.right = mid;
                    left_child.covered = covered;
                }
                left_child.add(left_, right_, carry);
            }
            if (right >= mid){
                if (right_child == null) {
                    right_child = new Segment();
                    right_child.right = right;
                    right_child.left = mid;
                    right_child.covered = covered;
                }
                right_child.add(left_, right_, carry);
            }
        }

        boolean find(int left_, int right_) {
            if (left_child == null && right_child == null) {
                return covered;
            }
            boolean result = true;
            int mid = (left + right) / 2;
            if (left_child != null && left_ < mid && right_ > left) {
                result = result && left_child.find(left_, right_);
            }
            if (right_child != null && right_ > mid && left_ < right) {
                result = result && right_child.find(left_, right_);
            }
            return result;

        }
    }

    public RangeModule() {
        top_interval = new Segment();
        top_interval.left = 1;
        top_interval.right = 1000000000;
    }

    public void addRange(int left, int right) {
        // System.out.println("Add: " + left + ", " + right);
        top_interval.add(left, right, true);
    }

    public void removeRange(int left, int right) {
        // System.out.println("Remove: " + left + ", " + right);
        top_interval.add(left, right, false);
    }

    public boolean queryRange(int left, int right) {
        return top_interval.find(left, right);
    }

}
