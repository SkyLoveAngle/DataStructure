package Homework0306;


import java.util.Scanner;

class Node {
    int val;
    Node prev = null;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }

}

          //实现一个双向链表

public class MyLinkedList {
    //记录头结点的位置
    private Node head;
    //记录尾节点的位置
    private Node tail;
    //记录链表的元素个数
    private int length = 0;

    public MyLinkedList() {
        //很明显，此处没有使用傀儡节点
        head = null;
        tail = null;
    }

    public int length() {
        return this.length;
    }

             //插入节点
    //1.头插
    public void addFirst(int val){
        Node newNode = new Node(val);
        // 空链表
        if (head == null) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        // 非空的情况
        newNode.next = head;
        head.prev = newNode;
        // 更新 head, 指向新的节点
        head = newNode;
        length++;
        return;
    }

    //2.尾插
    public void addLast(int val){
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length++;
            return;
        }
        // 非空的情况
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        length++;
    }

    //3.指定位置擦入
    public void addByIndex(int index,int val){
        // 先处理特殊情况
        if (index < 0 || index > length) {
            return;
        }
        // 处理头插
        if (index == 0) {
            addFirst(val);
            return;
        }
        // 处理尾插
        if (index == length) {
            addLast(val);
        }
        Node newNode = new Node(val);
        // 考虑一般的情况
        // 此时需要先找到 下标 => 节点~
        Node nextNode = getByIndex(index);
        // 接下来需要往 pos 之前插入 newNode
        // 咱们的目的是让新节点插入完毕后, 下标就是 index
        Node prevNode = nextNode.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = nextNode;
        nextNode.prev = newNode;

        length++;
    }

                //删除节点
    //头结点删除
    public void removeFirst() {
        // 考虑特殊情况
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            length = 0;
            return;
        }
        // 把第一个节点删除掉.
        Node nextNode = head.next;
        nextNode.prev = null;
        head = nextNode;
        length--;
    }

    //尾节点删除
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            length = 0;
            return;
        }
        Node prevNode = tail.prev;
        prevNode.next = null;
        tail = prevNode;
        length--;
    }


    //1.按照值删除
    public void removeByValue(int val){

    }

    //2.按照下标来删除
    public void removeByIndex(int index){
        if (index < 0 || index >= length) {
            return;
        }
        // 头删和尾删需要修改 head 和 tail
        if (index == 0) {
            // 头删
            // 特殊处理
            removeFirst();
            return;
        }
        if (index == length - 1) {
            // 尾删
            // 特殊处理
            removeLast();
            return;
        }
        // 一般的情况, 不需要修改 head 和 tail 的指向.
        // 1. 根据下标, 找到位置.
        Node toRemove = getByIndex(index);
        // 2. 记录前后节点的位置.
        Node prevNode = toRemove.prev;
        Node nextNode = toRemove.next;
        // 3. 删除节点
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        length--;
    }

               //查找节点

    // 1.根据下标找到节点
    public Node getByIndex(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //2.根据元素值查找
    public int getByValue(int value){
        Node cur = head;
        for (int i = 0; i < length; i++) {
            if (cur.val == value) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

                //修改节点
    public void set(int index,int val){
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node node = getByIndex(index);
        node.val = val;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
