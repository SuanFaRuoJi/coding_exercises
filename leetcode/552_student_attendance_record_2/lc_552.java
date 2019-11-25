import java.util.ArrayList;
import java.util.List;

public class lc_552 {
    private static List<long[]> memory = new ArrayList<>();

    public int checkRecord(int n) {
        int mod = 1000000000+7;
        int[][] A = {
                {2,1,1,3,1,0},
                {2,1,0,3,1,0},
                {1,1,0,2,1,0},
                {0,0,0,2,1,1},
                {0,0,0,2,1,0},
                {0,0,0,1,1,0}
        };
        if (memory.size() == 0) { // initialize the memory
            long[] zero = {1,0,0,0,0,0};
            long[] one = {1,1,0,1,0,0};
            memory.add(zero);
            memory.add(one);
        }
        for (int i=memory.size(); i<=n; i++) {
            long[] B = memory.get(i-2);
            memory.add(multiply(A, B));
        }
        long sum = 0;
        for (int i=0; i<6; i++) {
            sum += memory.get(n)[i] % mod;
        }
        return (int)(sum % mod);
    }

    private long[] multiply(int[][] A, long[] B) {
        int mod = 1000000000+7;
        long[] result = new long[6];
        for (int i=0; i<6; i++) {
            long sum = 0;
            for (int j=0; j<6; j++) {
                sum += A[j][i] * B[j];
            }
            result[i] = sum % mod;
        }
        return result;
    }
}
