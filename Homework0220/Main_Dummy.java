package Homework0220;
public class Main_Dummy {
    // 带傀儡节点的链表，
    // 本质的区别就在于傀儡节点中的值是不使用的,
    // 该链表认为长度是 4。
    public static Node createListWithDummy() {
        Node dummy = new Node(0);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        dummy.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return dummy;
    }

     /*
     带傀儡节点和不带傀儡节点, 是两种风格迥异的链表,
     不要尝试用一套代码来解决两种链表的问题,
     必须要分别实现。
     */

        // 遍历一个带傀儡节点的链表.
    public static void printWithDummy(Node head) {
        for (Node cur = head.next; cur != null; cur = cur.next) {
            System.out.print(cur.val+"  ");
        }
    }

        //带有傀儡节点的链表进行删除操作.
    public static Node removeWithDummy(Node head,int val){
        //此时我们就不用考虑到head引用修改的问题，也不用考虑删除第一个节点与删除后面节点存在的差异.
        Node prev =head;
        while(prev!=null && prev.next!=null && prev.next.val!=val){
            prev=prev.next;
        }
        //当这个循环结束，意味着要么prev到达了链表尾部，要么找到了val匹配的值.
        if (prev==null || prev.next==null){
            //认为没有找到这样的节点
            return head;
        }
        //找到节点.
        Node toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }

    public static void main(String[] args) {

        // 创建带傀儡节点的链表
        Node head1 = createListWithDummy();//此处的head就是指的傀儡节点
        System.out.print("创建一个带傀儡节点的链表1，遍历打印其中所有元素：");
        printWithDummy(head1);
        Node newNode1 = new Node(100);
        // 1. 往中间某个位置插入. 需要知道待插入位置的前一个位置.
        // 例如, 还是往 1 和 2 之间插入prev1 就是指向 1 的位置. prev1 名字的由来, 表示前一个元素。
        Node prev1 = head1.next;
        newNode1.next = prev1.next;
        prev1.next = newNode1;
        System.out.print("\n"+"在链表1第1和第2个节点之间插入一个值为100的新的节点，遍历打印链表：");
        printWithDummy(head1);

        System.out.println("\n"+"==========分===================割====================线==========");

        Node head2 = createListWithDummy();
        System.out.print("\n"+"创建一个带傀儡节点的链表2，遍历打印其中所有元素：");
        printWithDummy(head2);
        Node newNode2 = new Node(200);
        // 2. 往链表头部插入. (由于是带傀儡节点, 其实是插入到 head 的后面)
        Node prev2 = head2;
        newNode2.next = prev2.next;
        prev2.next = newNode2;
        System.out.print("\n"+"在链表2的头部插入一个值为200的新的节点，遍历打印链表：");
        printWithDummy(head2);

        System.out.print("\n"+"从链表2中删除节点值为3的节点，遍历打印链表：");
        removeWithDummy(head2,3);
        printWithDummy(head2);
    }
}
