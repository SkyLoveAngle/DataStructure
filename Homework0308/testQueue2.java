package Homework0308;

import org.omg.CORBA.INTERNAL;

//使用数组来实现环形链表
public class testQueue2 {
    private  int[] data = new int[100];
    //队列的有效区间[head，tail）
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    //核心操作
    //1.插入队列
    public boolean offer(int val){
        if (size==data.length){
            //队列满了，此处可以实现扩容逻辑
            return false;
        }
        //把新元素放到tail对应的下标上
        data[tail] = val;
        //自增tail
        tail++;
        //一旦tail到达数组的末尾，就需要让tail从头开始
        if (tail == data.length){
            tail = 0;
        }
        //上面的if语句可以等价于以下代码：
        //tail = tail % data.length;
        //更新size
        size++;
        return true;
    }
    //2.出队列
    public Integer poll(){
        if (size==0){
            return null;
        }
        int ret = data[head];
        //更新head的位置
        head++;
        if (head == data.length){
            head=0;
        }
        size--;
        return ret;
    }

    //3.获取队顶元素
    public Integer peek(){
        if (size == 0) {
            return null;
        }
        return data[head];
    }
}
