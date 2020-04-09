import java.util.HashMap;
import java.util.Map;

public class wsz_464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if ((maxChoosableInteger+1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int[] cross = new int[maxChoosableInteger + 1];
        return win(cross, desiredTotal, true, new HashMap<>());
    }

    private boolean win(int[] cross, int total, boolean myTurn, Map<String, Boolean> memory) {
        if (total <= 0) {
            return !myTurn;
        }
        String identifier = identify(cross, total, myTurn);
        if (memory.containsKey(identifier)) {
            return memory.get(identifier);
        }
        if (myTurn) { // only need one case to be winnable
            for (int i = cross.length-1; i > 0; i--) {
                if (cross[i] != 0) {
                    continue;
                }
                cross[i] = 1;
                //System.out.println("I: " + i);
                if (win(cross, total - i, !myTurn, memory)) {
                    cross[i] = 0;
                    memory.put(identifier, true);
                    return true;
                }
                cross[i] = 0;
            }
            memory.put(identifier, false);
            return false;
        } else { // need all cases to be winnable
            for (int i = cross.length-1; i > 0; i--) {
                if (cross[i] != 0) {
                    continue;
                }
                cross[i] = 1;
                //System.out.println("U: " + i);
                if (!win(cross, total - i, !myTurn, memory)) {
                    cross[i] = 0;
                    memory.put(identifier, false);
                    return false;
                }
                cross[i] = 0;
            }
            memory.put(identifier, true);
            return true;
        }
    }

    private String identify(int[] cross, int total, boolean myTurn) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < cross.length; i++) {
            if (cross[i] != 0) {
                sb.append(i + " ");
            }
        }
        sb.append(total + " ");
        sb.append(myTurn + " ");
        return sb.toString();
    }
}
