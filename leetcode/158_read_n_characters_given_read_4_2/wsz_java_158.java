public class wsz_java_158 {
    private char[] cache = new char[4];
    int cache_size = 0;

    private int read4(char[] buf) {
        return -1;
    }

    public int read(char[] buf, int n) {
        int cursor = 0;
        while(cursor != n) {
            if (cache_size != 0) { // read from cache
                if (cursor + cache_size >= n) { // cache overflow, end reading but keep cache
                    int i=0;
                    for (; cursor+i < n; i++) {
                        buf[cursor+i] = cache[i];
                    }
                    char[] new_cache = new char[4];
                    int new_cache_size = cache_size - i;
                    for (int j=0; j<new_cache_size; j++) {
                        new_cache[j] = cache[i+j];
                    }
                    cache = new_cache;
                    cache_size = new_cache_size;
                    return n;
                } else {
                    for (int i=0; i<cache_size; i++) {
                        buf[cursor++] = cache[i];
                    }
                    cache = new char[4];
                    cache_size = 0;
                }
            } else { // clean read
                char[] read_result = new char[4];
                int num_read = read4(read_result);
                if (num_read == 0) {
                    return cursor;
                }
                cache = read_result;
                cache_size = num_read;
            }
        }
        return -1;
    }
}
