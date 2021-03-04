package Homework0220;

public class Main_Normal {

        public static Node createList(){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
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

        //1)遍历一个不带傀儡节点的链表.
    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val+" ");
        }
    }

        //2)在链表末尾插一个节点（这个就不需要区分有没有傀儡节点的存在）.
    public static Node insertTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        // 1. 先找到末尾节点.
        Node prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        // 循环结束,  prev 就是最后一个节点了.
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

        //3)删除节点, 此处是按照目标节点的值来删除.
    public static Node remove_Value(Node head, int value) {
        if (head==null){
            return head;
        }
        if (head.val == value){
            //这就表示要删除的节点是头结点.
            head=head.next;
            return head;
        }
        // 1. 先找到 val 这个值对应的位置,同时也要找到 val 的前一个位置.
        Node prev = head;
        while (prev != null
                && prev.next != null
                && prev.next.val != value) {
            prev = prev.next;
        }
        // 循环结束之后, prev 就指向待删除节点的前一个节点了.
        if (prev == null || prev.next == null) {
            // 没有找到值为 val 的节点.
            System.out.print("遍历该链表后，没有找到你想删除的元素！");
            return head;
        }
        // 2. 真正进行删除了, toDelete 指向要被删除的节点.
        Node toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }

        //4)删除节点, 按照目标节点位置来删除.
    public static Node remove_Location(Node head, Node toDelete) {
        if (head==null){
            return head;
        }
        if (head==toDelete){
            //说明要删除的就是头结点.
            head=head.next;
            return head;
        }
        // 1. 先需要找到 toDelete 的前一个节点.
        Node prev = head;
        while (prev != null && prev.next != toDelete) {
            prev = prev.next;
        }
        if (prev == null) {
            // 没找到.
            return head;
        }
        // 2. 进行删除.
        prev.next = toDelete.next;
        return head;
    }

        //5)给定节点下标来删除.（类似数组下标也是从0开始）.
        //size()函数用来获取链表的大小.
    public static int size(Node head) {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public static Node remove_Subscript(Node head, int index) {
        if (index < 0 || index >= size(head)) {
            return head;
        }
        // 如果 index 为 0, 意味着要删除头结点.
        if (index == 0) {
            head = head.next;
            return head;
        }
        // 1. 还是要先找到待删除节点的前一个位置. index - 1 这个节点就是前一个位置.
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        // 循环结束之后, prev 就指向了待删除节点的前一个位置.
        // 2. 真正进行删除.
        Node toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }

        //6)不带傀儡节点的链表，进行尾删操作
    public static Node remove_Tail(Node head){
        if (head==null){
            return null;
        }
        if (head.next==null){
            //链表中只有一个节点，尾删的节点就是这个节点的本身.
            //此时删除该节点后，这个链表就变成了空表.
            return null;
        }
        //要想进行尾删操作，一般需要找到尾部节点的前一个节点.
        Node prev = head;

        /*这段代码不容易理解可以用下面的代码等价替换.
        while(prev!=null && prev.next!=null && prev.next.next!=null){
            prev=prev.next;
        }
         */
        Node toDelete = prev.next;
        while(prev!=null && prev.next!=null){
            toDelete=prev.next;
            if (toDelete.next==null){
                break;
            }
            prev=prev.next;
        }
        //接下来就是进行删除操作，由于toDelete节点已经是最后一个节点了，它的next一定是null.
        prev.next = toDelete.next;//prev.next=null;
        return head;
    }

    public static void main(String[] args) {

        //创建没有傀儡节点的链表.
        Node head1 = createList();
        System.out.print("创建一个普通链表1，遍历打印其中所有元素：");
        print(head1);

        //创建新的节点
        Node newNode = new Node(100);

        //把节点插入到第1和第2个元素之间
        Node prev = head1;
        //1).先把newNode的next指向prev的next.
        newNode.next = prev.next;
        //2).再把prev的next指向newNode.
        prev.next = newNode;

        System.out.print("\n"+"在链表1的第1和第2个元素之间插入值为100的新节点，遍历打印新链表：");
        print(head1);

        //需要注意的是：1和2代码片段的顺序一定不可以颠倒！！！
        System.out.println("\n"+"==========分===================割====================线==========");

        //把节点插入到链表的头部（会影响到head引用的指向）.
        Node head2 = createList();
        System.out.print("\n"+"创建一个普通链表2，遍历打印其中所有元素：");
        print(head2);
        //1）让newNode的next指向链表的第一个节点.
        newNode.next = head2;
        //2）让head指向新的节点.
        head2 = newNode;
        System.out.print("\n"+"在链表2的头部插入值为100的新节点，遍历打印新链表：");
        print(head2);
        System.out.println("\n"+"==========分===================割====================线==========");

        Node head3 = createList();
        System.out.print("\n"+"创建一个普通链表3，遍历打印其中所有元素：");
        print(head3);

        System.out.print("\n"+"在链表3的末尾插入一个值为200的新节点，遍历打印链表3：");
        insertTail(head3,200);
        print(head3);

        System.out.print("\n"+"在链表3中删除一个值为2的节点，遍历打印链表3：");
        remove_Value(head3,2);
        print(head3);

        System.out.print("\n"+"在链表3中删除一个值为2000的节点，遍历打印链表3：");
        remove_Value(head3,2000);
        print(head3);

        System.out.print("\n"+"在链表3中删除第4个节点，遍历打印链表3：");
        Node toDel = head3.next.next.next;
        remove_Location(head3,toDel);
        print(head3);

        System.out.print("\n"+"在链表3中删除下标为5的节点，遍历打印链表3：");
        remove_Subscript(head3,5);
        print(head3);

        System.out.print("\n"+"在链表3中删除末尾节点，遍历打印链表3：");
        remove_Tail(head3);
        print(head3);
        }
}
