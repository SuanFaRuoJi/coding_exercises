public class jcy_lc1666 {
    public Node flipBinaryTree(Node root, Node leaf) {
        Node newRoot = leaf, node = leaf, latest = null;
        while (node != root) {
            if (node.left != null)
                node.right = node.left;
            node.left = node.parent;
            if (node.parent.left == node)
                node.parent.left = null;
            else if (node.parent.right == node)
                node.parent.right = null;
            Node parent = node.parent;
            node.parent = latest;
            latest = node;
            node = parent;
        }
        node.parent = latest;
        return newRoot;
    }
}