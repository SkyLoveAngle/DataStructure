package Homework0308;

import java.util.Stack;

public class testLinkedList {
    //创建一个链表
    public static Node creatLinkedList() {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        Node e = new Node(9);
        Node f = new Node(2);
        Node g = new Node(4);
        Node h = new Node(6);
        Node i = new Node(8);
        Node j = new Node(10);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = null;
        return a;
    }
    //遍历打印链表元素
    public static void printLinkedList(Node head) {
        for (Node cur = head;cur != null;cur = cur.next){
            System.out.print(cur.val +" ");
        }
    }

    //判断链表是否回文（方法1）
    public static boolean isPalindrome1(Node head) {
        //判断边界情况
        if (head == null || head.next ==null){
            return true;
        }
        //将原链表复制到一个新链表上
        Node newHead = new Node(0);//创建傀儡节点方便复制
        Node newTail = newHead;
        for (Node cur=head;cur!=null;cur=cur.next){
            newTail.next=new Node(cur.val);
            newTail=newTail.next;
        }
        //将新链表进行翻转逆置
        Node DummyNext = newHead.next;
        Node prev = null;
        Node cur = DummyNext;
        while(cur!=null){
            Node next = cur.next; //此处的next定义必须放在while循环里面，因为cur一直在变化，得保证next跟cur一同变化.
            if (next == null){ //此处cur走到了链表最后一个元素，该元素为逆置链表的头结点
                DummyNext=cur;
            }
            cur.next = prev;
            prev=cur;
            cur=next;
        }
        //对比两个链表是否回文
        Node cur1 = head;
        Node cur2 = DummyNext;
        while(cur1 != null && cur2 != null){
            if (cur1.val != cur2.val){
                return false;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return true;
    }

    //判断链表是否回文（方法2，快慢指针的方法）
    public static boolean isPalindrome2(Node head) {
        Node fast = head;
        Node slow = head;
        //找到链表的中心点
        while (fast !=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //fast不为null，说明此时链表长度为奇数，此刻的中心节点为slow.next
        if(fast!=null){
            slow=slow.next;
        }
        //将slow后面的链表翻转
        slow=reverseLinkedList1(slow);

        fast=head;
        //比较是否为回文(用短的链表做参考）
        while(slow!=null){
            if (fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }


    //链表的逆置（方法1）
    public static Node reverseLinkedList1(Node head) {
        Node prev = null;
        Node cur =head;
        while(cur!=null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //链表的逆置（方法2）
    public static Node reverseLinkedList2(Node head) {

        Stack<Node> stack = new Stack<>();

        //把链表中的全部节点放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;

        Node node = stack.pop();
        Node dummy = node;
        //栈中的全部节点全部出栈，然后重新连接成一个链表
        while(!stack.isEmpty()){
            Node tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next等于null，否则会构成环
        node.next = null;
        return dummy;
    }



    public static void main(String[] args) {
        Node head = creatLinkedList();
        printLinkedList(head);
        System.out.println("\n");

        System.out.print(isPalindrome1(head));
        printLinkedList(head);
        System.out.println("\n");

        printLinkedList(head);
        printLinkedList(reverseLinkedList1(head));
        printLinkedList(head);
        System.out.println("\n");


        Node head2 = creatLinkedList();
        printLinkedList(reverseLinkedList2(head2));



    }



}
