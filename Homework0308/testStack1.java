package Homework0308;

public class testStack1 {

    //先使用顺序表来实现栈
    private int[] data = new int[100];
    private int size = 0;
    //基本操作
    //1.入栈
    public void push(int val){
        if (size >= data.length){
            //此处可以对数组进行扩容
            return;
        }
        data[size] = val;
        size++;
    }
    //2.出栈,返回值就是被出栈的那个元素
    public Integer pop(){
        if (size==0){
            return null;
        }
        //栈顶元素就是最后一个元素
        int ret = data[size-1];
        size--;
        return ret;
    }
    //3.取栈顶元素
    public Integer peek(){
        if (size==0){
            return null;
        }
        return data[size-1];
    }
}
