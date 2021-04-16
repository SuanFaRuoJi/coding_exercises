public class jcy_lc1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        for (int i = 0; i + 1 < sensor1.length; i++) {
            if (sensor1[i] != sensor2[i]) {
                while (i + 1 < sensor1.length && sensor1[i] == sensor2[i + 1])
                    i += 1;
                return i + 1 == sensor1.length ? 1 : 2;
            }
        }
        return -1;
    }
}