package Homework0313;

public class Node {
    String val;
    Node left;
    Node right;
    public Node(String val) {
        this.val = val;
    }
    @Override
    public String toString() {
        return "[" + val + "]";
    }
}


