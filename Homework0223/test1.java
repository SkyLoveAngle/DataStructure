package DataStructure.Homework0223;

//输入一个链表，输出该链表中倒数第k个结点。

public class test1 {
    public static Node createList(){
        Node a = new Node(1);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(9);
        Node j = new Node(9);
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

    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.val+" ");
        }
    }

    public static int getLength(Node head){
        int length=0;
        for (Node cur =head;cur != null;cur=cur.next){
            length++;
        }
        return length;
    }

    public static Node FindKthToTail(Node head, int k) {
        //合法性判定
        if (head==null || k<=0){
            return null;
        }
        int length = getLength(head);
        if (k>length){
            return null;
        }
//        Node pre = head;
//        Node last= head;
//        for (int i=1;i<k;i++){
//            if (pre.next != null){
//                pre=pre.next;
//            }else{
//                return null;
//            }
//        }
//        while (pre.next != null){
//            pre = pre.next;
//            last = last.next;
//        }
//        return last;

        int steps = length-k;
        Node cur =head;
        for (int i=0;i<steps;i++){
            cur=cur.next;
        }
        return cur;
    }

    public static Node partition(Node head, int x) {
        //方法1：
//        //以x为基点，新建两个链表存放<,>X的值。
//        Node less = null;   // 指向小链表的第一个结点
//        Node lessLast = null;   // 记录小链表的最后一个结点
//        Node great = null;
//        Node greatLast = null;
//
//        Node cur = head;
//        while (cur != null) {
//            if (cur.val < x) {
//                /* 尾插到小的链表中 */
//                if (less == null) {
//                    less = cur;
//                } else {
//                    lessLast.next = cur;
//                }
//                lessLast = cur;
//            } else {
//                /* 尾插到大的链表中 */
//                if (great == null) {
//                    great = cur;
//                } else {
//                    greatLast.next = cur;
//                }
//                greatLast = cur;
//            }
//            cur = cur.next;
//        }
//
//        if (less == null) {
//            return great;
//        } else {
//            lessLast.next = great;
//            if (greatLast != null) {
//                greatLast.next = null;
//            }
//            return less;
//        }

        //方法2：
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        //处理一般的情况，需要创建两个链表，用来保存两个部分的结果
        // 为了方便后续的尾插操作, 仍然使用带傀儡节点的链表, 同时记录链表末尾
        Node smallHead = new Node(0);
        Node smallTail = smallHead;
        Node largeHead = new Node(0);
        Node largeTail = largeHead;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 比基准值小, 就插入到 smallHead 的末尾
                // 由于旧的链表是使用 for 的方式直接遍历, 就会一直执行到 cur = cur.next
                //smallHead.next = cur;
                //smallHead = smallTail.next;
                // 通过这样的方式尾插, 可能会对原来链表的遍历造成影响. 稳妥起见, 创建新的节点, 而不是拆掉旧的链表.
                smallTail.next = new Node(cur.val);
                smallTail = smallTail.next;
            } else {
                // 大于等于基准值, 就插入到 largeHead 的末尾
                largeTail.next = new Node(cur.val);
                largeTail = largeTail.next;
            }
        }
        // 经过了上面的循环, 此时链表已经被拆成两个部分了.
        // 第一部分就都是小于 x 的元素.
        // 第二部分就都是大于等于 x 的元素.
        // 最后一步, 需要把两个链表合并成一个, 直接收尾相接即可.
        smallTail.next = largeHead.next;
        return smallHead.next;
    }

    public static Node deleteDuplication(Node head) {

//        if (head == null || head.next==null){
//            return head;
//        }
//        //迭代过程中处理重复的内容，然后继续迭代，参数是删除重复后的后一个节点
//        //首先判断是否有重复
//        if(head.val==head.next.val)
//        {
//            //有重复的话一直判断，是否有连续多个相同的重复
//             Node node=head.next;
//            //将所有重复的点忽略，直接连接到没有重复的点，也就是node
//            while(node!=null&&node.val==head.val)
//            {
//                node=node.next;
//            }
//            //在循环当中，一直在调用node.next所以，再次迭代中的参数就是已经删除重复的指针
//            return deleteDuplication(node);
//        }else
//        {
//            //如果没有重复的数字，那么我就让pHead的下一个节点继续迭代
//            //指向去除重复的下一个节点
//            //值得注意的是，题目中说返回链表的头指针，那么如何实现呢？
//            //第一次执行的时候pHead确实是链表的头指针，但是以后的迭代过程中就不是了
//            head.next=deleteDuplication(head.next);
//            return head;
//        }

        //先考虑特殊的极端情况
        if (head==null){
            return null;
        }
        //连表里只有一个节点
        if (head.next==null){
            return head;
        }
        //创建一个用来保存结果的链表，这是一个带傀儡节点的链表
        //为了尾插方便，记录链表的尾部节点
        Node newHead = new Node(0);
        Node newTail = newHead;
        //遍历链表，判定其中是否存在重复的元素
        Node cur=head;
        while ( cur != null ){
            //此处的循环条件不可以颠倒顺序
            //因为会触发短路求值，先求左边再求右边，如果此时cur为null，
            // 那么先判断cur.next会触发空指针异常
            if (cur.next != null && cur.val == cur.next.val){
                //此处是对cur和cur.next进行解引用，就需要注意会不会产生空指针异常的情况
                //发现cur是重复节点，就需要找接下来不重复节点的位置
                while (cur != null && cur.next != null && cur.val == cur.next.val){
                    cur=cur.next;
                }
                //上面的循环结束，要么是cur已经到达链表末尾，要么是cur遇到了重复节点的最后一个
                //需要让cur再走一步
                cur=cur.next;
            }else{
                //cur不是重复节点，直接诶插入到newHead末尾
                newTail.next = new Node(cur.val);
                newTail = newTail.next;
                cur=cur.next;
            }
        }
        return newHead.next;
    }


    public static boolean isPalindrome(Node head) {

//        if (head == null || head.next == null){
//            return true;
//        }
//
//        Node fast = head;
//        Node slow = head;
//        while(fast.next != null && fast.next.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        fast = slow.next;
//        slow.next = null;
//        Node node =null;
//        while(fast != null){
//            node = fast.next;
//            fast.next = slow;
//            slow = fast;
//            fast = node;
//        }
//
//        fast = head;
//        boolean res = true;
//        while (slow != null && fast != null) {
//            if (slow.val != fast.val) {
//                res = false;
//                break;
//            }
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return res;

        //判断特殊情况
        if (head == null){
            return true;
        }
        if (head.next == null){
            return true;
        }

        //把原来的链表复制一份
        Node newHead = new Node(0);//傀儡节点
        Node newTail = newHead;
        for (Node cur = head;cur!=null;cur=cur.next){
            newTail.next = new Node(cur.val);
            newTail = newTail.next;
        }

        Node DummyNext = newHead.next;
        //把新链表进行逆置
        Node prev = null;
        Node cur = DummyNext;
        while (cur != null){
            Node next = cur.next;
            if (next == null){
                //cur就指向的就是最后一个节点，也就是逆置链表的头结点
                DummyNext = cur;
            }
            //逆置核心操作：掰道岔
            cur.next = prev;
            //更新循环变量
            prev = cur;
            cur = next;
        }

        //对比两个链表是否相等
        Node cur1 = head;
        Node cur2 = DummyNext;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                // 找到了反例, 不是回文
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 找了一圈下来也没找到反例, 于是就判定这是回文
        return true;
    }

    public static void main(String[] args) {
        Node head = createList();

        System.out.print("创建一个普通链表，遍历打印其中所有元素：");
        print(head);

        System.out.print("\n"+"输出该链表中倒数第6个节点：");
        print(FindKthToTail(head,6));

        System.out.print("\n"+"以9为基准将链表分割成两部分，<9的结点排在>=9的结点之前：");
        print(partition(head, 9));

        System.out.print("\n"+"删除链表中连续重复的结点，重复的结点不保留:");
        print(deleteDuplication(head));

        System.out.print("\n"+"判断链表是否为回文结构："+isPalindrome(head));
    }
}

