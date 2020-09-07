public class wsz_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int[] front_stack = new int[arr.length], end_stack = new int[arr.length];
        int front_top = 0, end_top = 0;
        for (int i=0; i<arr.length; i++) {
            if (front_top == 0 || arr[i] >= front_stack[front_top-1]) {
                front_stack[front_top++] = arr[i];
            } else {
                break;
            }
        }
        for (int i=arr.length-1; i>=0; i--) {
            if (end_top == 0 || arr[i] <= end_stack[end_top-1]) {
                end_stack[end_top++] = arr[i];
            } else {
                break;
            }
        }
        int max = 0;
        for (int i=0; i<front_top; i++) {
            while (end_top != 0 && end_stack[end_top] > front_stack[i]) {
                end_top --;
            }
            int local = i + end_top;
            if (local > max) {
                max = local;
            }
        }
        return arr.length - max;
    }
}
