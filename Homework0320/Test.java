package Homework0320;

//import java.util.Comparator;
//import java.util.PriorityQueue;
//class Boy implements Comparable<Boy> {
//    public String name;
//    public int age;
//    public int money; // 有钱
//    public int face;  // 有颜
//
//    public Boy(String name, int age, int money, int face) {
//        this.name = name;
//        this.age = age;
//        this.money = money;
//        this.face = face;
//    }
//
//    @Override
//    public int compareTo(Boy o) {
////        return this.money - o.money;
//        return o.money - this.money;
//    }
//}
//
//class BoyComparator implements Comparator<Boy> {
//    @Override
//    public int compare(Boy o1, Boy o2) {
//        return o1.money - o2.money;
//    }
//}

import java.util.PriorityQueue;




public class Test {
    public static void main(String[] args) {

//        //定义一个优先队列，并且打印输出！
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        int[] arr = {9,5,2,7,3,6,8};
//        for (int x: arr){
//            queue.offer(x);
//        }
//        System.out.print("优先队列输出结果：");
//        while (!queue.isEmpty()){
//            Integer x = queue.poll();
//            System.out.print(x+" ");
//        }

        // 这里有个问题!
        // 优先级队列中的元素的 "大小关系" 该如何制定??

//        Boy[] arr1 = {
//                new Boy("张三", 20, 10, 100),
//                new Boy("李四", 40, 100, 10),
//                new Boy("王五", 30, 50, 50),
//                new Boy("赵六", 50, 120, 5),
//        };
//
//        PriorityQueue<Boy> queue1 = new PriorityQueue<>();
//        for (Boy boy : arr1) {
//            queue1.offer(boy);
//        }
//        System.out.print("根据每个人的money大小进行队列优先排序：");
//        while (!queue1.isEmpty()) {
//            Boy cur = queue1.poll();
//            System.out.print(cur.name+" ");
//        }




        int[] arr = {4,1,9,2,8,0,7,3,6,5};
        // 一般在创建优先级队列对象时，如果知道元素个数，建议就直接将底层容量给好
        // 否则在插入时需要不多的扩容
        // 扩容机制：开辟更大的空间，拷贝元素，这样效率会比较低
        PriorityQueue<Integer> q = new PriorityQueue<>(arr.length);
        for (int e: arr) {
            q.offer(e);
        }
//        System.out.print("队列输出结果：");
//        while (!q.isEmpty()){
//            Integer x = q.poll();
//            System.out.print(x+" ");
//        }
        System.out.println("\n"+"打印优先级队列中有效元素个数:"+q.size());
        System.out.println("\n"+"获取优先级最高的元素:"+q.peek());
        System.out.println("\n"+"从优先级队列中删除两个元素之和，再次获取优先级最高的元素!!!");
        q.poll();
        q.poll();
        System.out.println("\n"+"打印优先级队列中有效元素个数:"+q.size());
        System.out.println("\n"+"获取优先级最高的元素:"+q.peek());
        System.out.println("\n"+"入队一个元素“0”！！！");
        q.offer(0);
        System.out.println("\n"+"获取优先级最高的元素:"+q.peek());
        System.out.println("\n"+"将优先级队列中的有效元素删除掉，检测其是否为空!!!");
        q.clear();
        if(q.isEmpty()){
            System.out.println("优先级队列已经为空!!!");
        }else{
            System.out.println("优先级队列不为空");
        }
    }
}
