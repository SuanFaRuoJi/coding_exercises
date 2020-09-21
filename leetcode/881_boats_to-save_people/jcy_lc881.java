import java.util.Arrays;

public class jcy_lc881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, res = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) i += 1;
            j -= 1;
            res += 1;
        }
        return res;
    }
}