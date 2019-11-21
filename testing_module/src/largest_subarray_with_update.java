import java.util.Scanner;

public class largest_subarray_with_update {
    private static int get_max_sum(int[] arr){
        int accumulate = 0, max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            accumulate += arr[i];
            if (accumulate < 0){
                accumulate = 0;
            }
            if (accumulate > max){
                max = accumulate;
            }
        }
        return max;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i=0; i<size; i++){
            arr[i] = scanner.nextInt();
            //System.out.println(arr[i]);
        }
        int ops = scanner.nextInt();
        for (int i=0; i<ops; i++){
            int index = scanner.nextInt(), val = scanner.nextInt();
            arr[index] = val;
            System.out.println(get_max_sum(arr));
        }
    }
}
