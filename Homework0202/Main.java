package Homework0202;
public class Main {
    // 通过这个方法, 创建出一个固定内容的链表.
    // 使用头结点来代指整个链表.
    // 让方法把头结点返回回去就行了
    public static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;
    }

    public static void main(String[] args) {
        Node head = createList();

//        //1.遍历链表，把各个元素打印出来
//        for (Node cur=head;cur!=null;cur=cur.next){
//            System.out.println(cur.val);
//        }

//        //2.通过遍历，找到链表的最后一个结点。
//        //head = null; //链表的头节点是 null, 此时就表示一个空的链表(一个节点都没有的链表)
//        Node cur = head;
//        while (cur != null && cur.next != null) {
//            cur = cur.next;
//        }
//        // 一旦循环结束,
//        // cur 就指向了链表的最后一个节点.
//        System.out.println(cur.val);

//        //3.通过遍历，找到链表的倒数第二个结点。
//        // 特点就是 .next.next 为 null
//        Node cur = head;
//        while (cur != null && cur.next != null && cur.next.next != null) {
//            cur = cur.next;
//        }
//        System.out.println(cur.val);

        //4.通过遍历，找到链表的第 n 个结点。（链表的长度 >= n)
//        int N = 3;
//        Node cur = head;
//        for (int i = 1; i < N; i++) {
//            cur = cur.next;
//        }
//        // 此时 cur 指向的元素, 就是正数第 N 个元素.(这儿不是在算下标)
//        System.out.println(cur.val);

//        //5.通过遍历，计算链表中元素的个数。
//        int count = 0;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            count++;
//        }
//        System.out.println(count);

        //结合第4,5代码就可以实现“获取链表中倒数第N个节点的元素”，
        // 倒数第N个节点就是正数“链表元素总个数+1-N”个元素。

//        //6.通过遍历，找到链表中是否包含某个元素。
//        int toFind = 3;
//        Node cur = head;
//        for (; cur != null; cur = cur.next) {
//            if (cur.val == toFind) {
//                break;
//            }
//        }
//        if (cur != null) {
//            System.out.println("找到了！");
//        } else {
//            System.out.println("没找到！");
//        }
    }
}
