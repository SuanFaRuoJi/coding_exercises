public class Node2 {
    char val;
    Node2 left;
    Node2 right;
    Node2() {this.val = ' ';}
    Node2(char val) { this.val = val; }
    Node2(char val, Node2 left, Node2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
