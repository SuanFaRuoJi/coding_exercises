class wsz_java{
    public int lastRemaining(int n) {
        int remain = n, head = 1, step = 1, times = 0;
        while(remain != 1){
            if (times%2 == 0 || remain%2 == 1){
                head += step;
            }
            times++;
            step *= 2;
            remain /= 2;
        }
        return head;
    }
}
