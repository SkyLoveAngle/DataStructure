package Homework0221;

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

        //1.遍历链表，把各个元素打印出来
        System.out.print("遍历链表，打印所有元素：");
        for (Node cur1 = head; cur1 != null; cur1 = cur1.next) {
            System.out.print(cur1.val);
        }

        //2.通过遍历，找到链表的最后一个结点。
        //head = null;
        // 链表的头节点是 null, 此时就表示一个空的链表(一个节点都没有的链表)
        System.out.print("\n"+"遍历链表，找到最后一个节点：");
        Node cur2 = head;
        while (cur2 != null && cur2.next != null) {
            cur2 = cur2.next;
        }
        // 一旦循环结束,cur 就指向了链表的最后一个节点.
        System.out.println(cur2.val);

        //3.通过遍历，找到链表的倒数第二个结点。
        // 特点就是 cur.next.next 为 null
        System.out.print("遍历链表，找到倒数第二个节点：");
        Node cur3 = head;
        while (cur3 != null && cur3.next != null && cur3.next.next != null) {
            cur3 = cur3.next;
        }
        System.out.print(cur3.val);

        //4.通过遍历，找到链表的第 n 个结点。（链表的长度 >= n)
        System.out.print("\n"+"遍历链表，找到第3个节点：");
        int N = 3;
        Node cur4 = head;
        for (int i = 1; i < N; i++) {
            cur4 = cur4.next;
        }
        // 此时 cur 指向的元素, 就是正数第 N 个元素.(这儿不是在算下标)
        System.out.print(cur4.val);

        //5.通过遍历，计算链表中元素的个数。
        System.out.print("\n"+"遍历链表，计算链表元素总数：");
        int count = 0;
        for (Node cur5 = head; cur5 != null; cur5 = cur5.next) {
            count++;
        }
        System.out.print(count);

        /*
        结合第4,5代码就可以实现“获取链表中倒数第N个节点的元素”，
        倒数第N个节点就是正数“链表元素总个数+1-N”个元素。
         */

        //6.通过遍历，找到链表中是否包含某个元素。
        System.out.print("\n"+"遍历链表，判断是否包含元素值为3的元素：");
        int toFind = 3;
        Node cur6 = head;
        for (; cur6 != null; cur6 = cur6.next) {
            if (cur6.val == toFind) {
                break;
            }
        }
        if (cur6 != null) {
            System.out.print("找到了元素值为"+toFind+"的元素！");
        } else {
            System.out.print("没找到元素值为"+toFind+"的元素！");
        }
    }
}