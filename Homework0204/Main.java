
//package Homework0204;
//public class Main {
//    /*
//    请将给定数组，转换成链表
//     */
//
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
//
//
//    //返回的链表是一个不带傀儡节点的链表
//    public static Node arrayToLinkedList1(int[] array){
//        /*
//        遍历数组，把元素依次进行尾插即可
//        每次尾插都需要知道当前链表的末尾节点
//        如果每次都重新遍历链表找末尾节点很麻烦，我们可以直接使用一个引用把末尾节点记住
//        head就是头结点的引用，初始情况下，链表是空的
//         */
//        Node head=null;
//        Node tail=null;
//        for (int x:array){
//            Node node = new Node(x);
//            //把node进行尾插，需要判断当前链表是否为空
//            if (head==null){
//                head=node;
//                tail=node;
//            }else{
//                //链表不为空的时候，再进行新的插入，此时不需要管head，直接在tail后面操作
//                tail.next = node;
//                //一旦插入完成，新的节点就变成了tail，就需要更新tail的指向
//                tail = tail.next;
//            }
//        }
//        return head;
//}
//
//
//    public static Node arrayToLinkedList2(int[] array) {
//        //使用更简单的方式完成
//        //如果创建一个带傀儡节点的链表的话，后续的尾插操作，就不需要分两种情况来讨论了
//        //此时的head指向傀儡节点
//        Node head=new Node(0);
//        //也需要创建一个tail来保存链表的尾巴
//        Node tail = head;
//
//        for (int x:array){
//            //此时就把两种插入操作合并成一种操作
//            Node node = new Node(x);
//            tail.next=node;
//            tail=tail.next;
//        }
//        //代码要求的返回结果是一个不带傀儡节点的链表
//        //如果返回的是head，head指向的是傀儡节点，不符合要求
//        //返回head.next就正好合适
//        return head.next;
//    }
//
//
//    public static void main(String[] args) {
//        int[] array={1,2,3,4,5};
//        Node head =arrayToLinkedList1(array);
//        print(head);
//    }
//}
//
