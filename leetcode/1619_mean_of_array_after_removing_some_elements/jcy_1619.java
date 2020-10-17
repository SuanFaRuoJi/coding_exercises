import java.util.Arrays;

public class jcy_1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        double sum = 0;
        for (int i = n / 20; i < n - n / 20; i++)
            sum += arr[i];
        return sum / (n - n / 10);
    }
}