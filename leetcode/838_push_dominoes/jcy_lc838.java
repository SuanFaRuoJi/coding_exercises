public class jcy_lc838 {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length, force = 0;
        int[] forces = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') force = n;
            else if (arr[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') force = n;
            else if (arr[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }
        StringBuilder sb = new StringBuilder();
        for (int f : forces)
            sb.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return sb.toString();
    }
}