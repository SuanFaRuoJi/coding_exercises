public class jcy_lc1812 {
    public boolean squareIsWhite(String coordinates) {
        return (int)coordinates.charAt(0) % 2 != (int)coordinates.charAt(1) % 2;
    }
}