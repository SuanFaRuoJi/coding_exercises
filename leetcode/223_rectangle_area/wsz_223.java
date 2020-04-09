public class wsz_223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long a1 = (C - A) * (D - B), a2 = (G - E) * (H - F), overlap = 0;
        long X1 = Math.max(A, E), Y1 = Math.max(B, F), X2 = Math.min(C, G), Y2 = Math.min(D, H);
        overlap = Math.max(0, X2 - X1) * Math.max(0, Y2 - Y1);
        return (int) (a1 + a2 - overlap);
    }
}
