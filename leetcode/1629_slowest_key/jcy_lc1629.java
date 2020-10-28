public class jcy_lc1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = keysPressed.charAt(0);
        int maxDur = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int curDur = releaseTimes[i] - releaseTimes[i - 1];
            if (curDur > maxDur) {
                maxDur = curDur;
                res = keysPressed.charAt(i);
            } else if (curDur == maxDur && keysPressed.charAt(i) > res)
                res = keysPressed.charAt(i);
        }
        return res;
    }
}