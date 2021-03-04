package DataStructure.Homework0203;

//public class Main {
//    public static Node createList(){
//        Node a = new Node(1);
//        Node b = new Node(2);
//        Node c = new Node(3);
//        Node d = new Node(4);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = null;
//        return a;
//    }

    // 带傀儡节点的链表，
    // 本质的区别就在于傀儡节点中的值是不使用的,
    // 该链表认为长度是 4。
//    public static Node createListWithDummy() {
//        Node dummy = new Node(0);
//        Node a = new Node(1);
//        Node b = new Node(2);
//        Node c = new Node(3);
//        Node d = new Node(4);
//        dummy.next = a;
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = null;
//        return dummy;
//    }

     /*
     带傀儡节点和不带傀儡节点, 是两种风格迥异的链表,
     不要尝试用一套代码来解决两种链表的问题,
     必须要分别实现。
     */

//    // 遍历一个不带傀儡节点的链表
//    public static void print(Node head) {
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }
//    }
//
//    // 遍历一个带傀儡节点的链表
//    public static void printWithDummy(Node head) {
//        for (Node cur = head.next; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }
//    }



//    // 在链表末尾插一个节点（这个就不需要区分有没有傀儡节点的存在）
//    public static Node insertTail(Node head, int val) {
//        Node newNode = new Node(val);
//        if (head == null) {
//            return newNode;
//        }
//        // 1. 先找到末尾节点
//        Node prev = head;
//        while (prev.next != null) {
//            prev = prev.next;
//        }
//        // 循环结束,  prev 就是最后一个节点了~
//        newNode.next = prev.next;
//        prev.next = newNode;
//        return head;
//    }

//    // 删除节点, 此处是按照值来删除
//    public static Node remove(Node head, int value) {
//        if (head==null){
//            return head;
//        }
//        if (head.val == value){
//            //这就表示要删除的节点是头结点
//            head=head.next;
//            return head;
//        }
//
//        // 1. 先找到 val 这个值对应的位置
//        //    同时也要找到 val 的前一个位置
//        Node prev = head;
//        while (prev != null
//                && prev.next != null
//                && prev.next.val != value) {
//            prev = prev.next;
//        }
//        // 循环结束之后, prev 就指向待删除节点的前一个节点了.
//        if (prev == null || prev.next == null) {
//            // 没有找到值为 val 的节点
//            return head;
//        }
//        // 2. 真正进行删除了, toDelete 指向要被删除的节点
//        Node toDelete = prev.next;
//        prev.next = toDelete.next;
//        return head;
//    }
//
//    // 删除节点, 按照位置来删除.
//    public static Node remove(Node head, Node toDelete) {
//        if (head==null){
//            return head;
//        }
//        if (head==toDelete){
//            //说明要删除的就是头结点
//            head=head.next;
//            return head;
//        }
//        // 1. 先需要找到 toDelete 的前一个节点
//        Node prev = head;
//        while (prev != null && prev.next != toDelete) {
//            prev = prev.next;
//        }
//        if (prev == null) {
//            // 没找到
//            return head;
//        }
//        // 2. 进行删除
//        prev.next = toDelete.next;
//        return head;
//    }
//
//
//    public static Node remove2(Node head, Node toDelete) {  //这个方案时间复杂度O(1)\\
//        if (head==null){
//           return head;
//        }
//        Node nextNode = toDelete.next;
//        toDelete.val = nextNode.val;
//        toDelete.next = nextNode.next;
//        return head;
//    }//这个方案有一个局限性，就是无法处理末尾节点的删除
//
//
//
//    public static int size(Node head) {
//        int size = 0;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            size++;
//        }
//        return size;
//    }
//    // 给定节点下标来删除.（类似数组下标也是从0开始）
//    public static Node remove3(Node head, int index) {
//        if (index < 0 || index >= size(head)) {
//            return head;
//        }
//        // 如果 index 为 0, 意味着要删除头结点
//        if (index == 0) {
//            head = head.next;
//            return head;
//        }
//        // 1. 还是要先找到待删除节点的前一个位置. index - 1 这个节点就是前一个位置
//        Node prev = head;
//        for (int i = 0; i < index - 1; i++) {
//            prev = prev.next;
//        }
//        // 循环结束之后, prev 就指向了待删除节点的前一个位置
//        // 2. 真正进行删除
//        Node toDelete = prev.next;
//        prev.next = toDelete.next;
//        return head;
//    }
//
//
//    //带有傀儡节点的链表进行删除操作
//    public static void removeWithDummy(Node head,int val){
//        //此时我们就不用考虑到head引用修改的问题，也不用考虑删除第一个节点与删除后面节点存在的差异
//        Node prev =head;
//        while(prev!=null && prev.next!=null && prev.next.val!=val){
//            prev=prev.next;
//        }
//        //当这个循环结束，意味着要么prev到达了链表尾部，要么找到了val匹配的值
//        if (prev==null || prev.next==null){
//            //认为没有找到这样的节点
//            return;
//        }
//        //找到节点
//        Node toDelete = prev.next;
//        prev.next = toDelete.next;
//        return;
//    }
//
//    //不带傀儡节点的链表，进行尾删操作
//    public static Node removeTail(Node head){
//        if (head==null){
//            return null;
//        }
//        if (head.next==null){
//            //链表中只有一个节点，尾删的节点就是这个节点的本身
//            //此时删除该节点后，这个链表就变成了空表
//            return null;
//        }
//        //要想进行尾删操作，一般需要找到尾部节点的前一个节点
//        Node prev = head;
//        /*这段代码不容易理解可以用下面的代码等价替换
//        while(prev!=null && prev.next!=null && prev.next.next!=null){
//            prev=prev.next;
//        }
//         */
//        Node toDelete = prev.next;
//        while(prev!=null && prev.next!=null){
//            toDelete=prev.next;
//            if (toDelete.next==null){
//                break;
//            }
//            prev=prev.next;
//        }
//        //接下来就是进行删除操作，由于toDelete节点已经是最后一个节点了，它的next一定是null
//        prev.next = toDelete.next;//prev.next=null;
//        return head;
//    }



//    public static void main(String[] args) {

          //创建没有傀儡节点的链表
//        Node head = createList();
//
//        //创建新的节点
//        Node newNode = new Node(100);

//        //把节点插入到1和2之间
//        Node prev = head;
//        //1).先把newNode的next指向prev的next
//        newNode.next = prev.next;
//        //2).再把prev的next指向newNode
//        prev.next = newNode;

//        //需要注意的是：1和2代码片段的顺序一定不可以颠倒！！！
//
//        //把节点插入到链表的头部（会影响到head引用的指向）
//        //1）让newNode的next指向链表的第一个节点
//        newNode.next = head;
//        //2）让head指向新的节点
//        head = newNode;


        // 创建带傀儡节点的链表
//        Node head = createListWithDummy();//此处的head就是指的傀儡节点
//        Node newNode = new Node(100);

        // 1. 往中间某个位置插入. 需要知道待插入位置的前一个位置.
        //    例如, 还是往 1 和 2 之间插入
        //    prev 就是指向 1 的位置. prev 名字的由来, 表示前一个元素
//        Node prev = head.next;
//        newNode.next = prev.next;
//        prev.next = newNode;

        // 2. 往链表头部插入. (由于是带傀儡节点, 其实是插入到 head 的后面)
//        Node prev = head;
//        newNode.next = prev.next;
//        prev.next = newNode;


//        Node head = createList();

//        Node head = null;
//        head = insertTail(head, 100);
//        print(head);

//        Node head = createList();
//        // toDelete 指向 3 这个节点了.
//        Node toDelete = head.next.next;
//        remove(head, toDelete);
//        print(head);
//
//    }
//}
