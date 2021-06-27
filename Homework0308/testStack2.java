package Homework0308;

import sun.awt.image.ImageWatched;

//使用链表来实现栈

//class LinkedList {
//    int val;
//    Node next;
//    public LinkedList(int val) {
//        this.val = val;
//    }
//}

//首先需要定义一个链表，此处Node.class里面已经进行定义了！

public class testStack2 {
    // 此处使用不带傀儡节点的链表来表示.
    // 如果使用带傀儡节点的链表的话, 就更简单了.
    public Node head = null;

    //核心操作
    //1.入栈操作
    public void push(int val){
        Node newNode = new Node(val);
        // 把新节点进行头插
        // 由于当前是不带傀儡节点的, 所以就需要判定当前链表是空还是非空
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    //2.出栈操作
    public Integer pop(){
        if (head==null){
            return null;
        }
        if (head.next==null){
            int ret = head.val;
            head=null;
            return ret;
        }
        int ret = head.val;
        head=head.next;
        return ret;
    }

    //3.找出栈顶元素
    public Integer peek(){
        if (head==null){
            return null;
        }
        return head.val;
    }

}
