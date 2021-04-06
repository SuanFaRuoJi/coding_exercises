public class jcy_lc1698 {
    class Node {
        Node[] children = new Node[26];

    }

    public int countDistinct(String s) {
        Node root = new Node();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                if (cur.children[s.charAt(j) - 'a'] == null) {
                    cur.children[s.charAt(j) - 'a'] = new Node();
                    res += 1;
                }
                cur = cur.children[s.charAt(j) - 'a'];
            }
        }
        return res;
    }
}