package Homework0223;

public class Node {
    public int val;
    public Node next = null;
    //java中只能靠引用来保存地址，你的地址指向什么类型的对象，引用的类型也是一样的

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
