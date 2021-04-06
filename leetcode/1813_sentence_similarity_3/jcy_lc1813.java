public class jcy_lc1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int idx = 0, n1 = words1.length, n2 = words2.length;
        if (n1 > n2) return areSentencesSimilar(sentence2, sentence1);
        while (idx < n1 && words1[idx].equals(words2[idx])) idx += 1;
        while (idx < n1 && words1[idx].equals(words2[n2 - n1 + idx])) idx += 1;
        return idx == n1;
    }
}