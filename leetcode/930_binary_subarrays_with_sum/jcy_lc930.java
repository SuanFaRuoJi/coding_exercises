public class jcy_lc930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int iLo = 0, iHi = 0, sumLo = 0, sumHi = 0, res = 0;
        for (int j = 0; j < A.length; j++) {
            sumLo += A[j];
            while (iLo < j && sumLo > S)
                sumLo -= A[iLo++];
            sumHi += A[j];
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0))
                sumHi -= A[iHi++];
            if (sumLo == S) res += iHi - iLo + 1;
        }
        return res;
    }
}