package Homework0308;

import org.omg.PortableInterceptor.INACTIVE;

//使用链表实现队列
public class testQueue1 {
    //创建一个链表的头结点和尾节点
    Node head = null;
    Node tail = null;

    //队列的核心操作
    //1.入队列,返回值表示插入成功/失败
    public boolean offer(int val){
        Node newNode = new Node(val);
        if (head==null){
            head=newNode;
            tail=newNode;
            return true;
        }
        tail.next=newNode;
        tail=tail.next;
        return true;
    }
    //2.出队列
    public Integer poll(){
        if (head==null){
            return null;
        }
        int ret = head.val;
        if (head.next==null){
            head=null;
            return ret;
        }
        head = head.next;
        return ret;
    }

    //3.取队首元素
    public Integer peek(){
        if (head==null){
            return null;
        }
        return head.val;
    }

    public static void main(String[] args) {
        // 测试一下入队出队操作
        testQueue1 myQueue = new testQueue1();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);

        Integer ret = null;
        ret = myQueue.poll();
        System.out.println("ret = " + ret);
        ret = myQueue.poll();
        System.out.println("ret = " + ret);
        ret = myQueue.poll();
        System.out.println("ret = " + ret);
        ret = myQueue.poll();
        System.out.println("ret = " + ret);
        ret = myQueue.poll();
        System.out.println("ret = " + ret);
    }
}
