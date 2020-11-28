public class Node3 {
    public boolean val;
    public boolean isLeaf;
    public Node3 topLeft;
    public Node3 topRight;
    public Node3 bottomLeft;
    public Node3 bottomRight;


    public Node3() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node3(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node3(boolean val, boolean isLeaf, Node3 topLeft, Node3 topRight, Node3 bottomLeft, Node3 bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}