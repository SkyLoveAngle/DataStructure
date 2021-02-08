package Homework0201;

public class myArrayList {
    //属性
    private String[] data = null;
    //当前顺序表中的有效元素个数
    private int size = 0;
    //当前顺序表的最大容量，如果size超过了capacity则需要扩容
    private int capacity = 100;

    //构造方法
    public myArrayList() {
        data = new String[capacity] ;
    }

    //实现扩容
    private void realloc(){
        //先把capacity变大，具体变大多少可以视情况而定。
        capacity = 2*capacity;
        String[] newData = new String[capacity];
        //把旧的数组中的数据拷贝到新的数组中
        for (int i=0;i<data.length;i++){
            newData[i]=data[i];
        }
        //把新的大的数组赋值给原有的属性 data，同时就会释放掉旧的数组（GC会处理）
        data = newData;//这个地方其实是引用（将地址）进行赋值
    }

    @Override//重写toString方法
    public String toString() {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    //方法,增，删，改，查

    //1.元素尾查到顺序表末尾,时间复杂度：O(1),因为顺序表的扩容操作是一个极小概率的事件
    public void add(String elem){
        if (size >capacity){
            //需要先扩容
            realloc();    //O(N)
        }
        //就直接把新的元素放到下标为size的位置上
        data[size] = elem;//O(1)
        size++;
    }

    //2.将elem元素添加到指定位置index处
    public void add(int index,String elem){
        //判断一下index是否在合理范围内
        if (index < 0 || index > size) {
            return;
        }
        if (size >capacity){
            realloc();
        }
        //把elem放到index位置，不能覆盖掉已有的元素
        //需要把index位置及其后面位置所有的元素往后依次搬运，给index位置腾出一个空位置，然后把elem放到该位置
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        //搬运完成后，把elem放到index位置上
        data[index]=elem;
        size++;
    }

    //3.按照下标位置删除元素，这个方法的返回值结果就是被删除的元素
    public String remove(int index){
        // 仍然是需要进行搬运. 把 index 位置的元素覆盖掉即可
        if (index < 0 || index >= size) {
            return null;
        }
        String result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        // 别忘记 size 更新
        size--;
        return result;
    }

    //4.按照元素的值来删除元素，这个方法返回成功/失败
    public boolean remove(String elem){
        // 先找到元素所在的位置
        int index = 0;
        for (; index < size; index++) {
            if (data[index].equals(elem)) {
                break;
            }
        }
        if (index >= size) {
            // 没找到匹配的元素, 删除失败
            return false;
        }
        // 找到匹配的元素了, 从 index 位置开始进行搬运
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }


    class MyArrayListIndexOutOfRangeException extends RuntimeException {
        public MyArrayListIndexOutOfRangeException(String message) {
            super(message);
        }
    }
    // 5. 根据下标获取元素
    public String get(int index) {
        if (index < 0 || index >= size) {
            // 此处可以返回 null, 也可以跑出一个异常
            // return null;
            throw new MyArrayListIndexOutOfRangeException("下标越界了! index: " + index);
        }
        return data[index];
    }

    // 6. 根据下标修改元素
    public void set(int index, String elem) {
        if (index < 0 || index >= size) {
            // 此处可以返回 null, 也可以跑出一个异常
            // return null;
            throw new MyArrayListIndexOutOfRangeException("下标越界了! index: " + index);
        }
        data[index] = elem;
    }

    // 7. 判断元素是否存在
    public boolean contains(String elem) {
        // 此处不太方便用 for each.
        // for each 是遍历了整个 data 的所有元素.
        // 实际上只需要遍历其中的前 size 个元素即可.
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    // 8. 查找元素位置
    public int indexOf(String elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    // 9. 查找元素位置(从后往前找)
    public int lastIndexOf(String elem) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    //10.清空顺序表
    public void clear() {
        size = 0;
    }

    //11.查看顺序表大小
    public int size() {
        return size;
    }

    //12.判断顺序表是否为空表
    public boolean isEmpty() {
        return size == 0;
    }

    private static void testAdd(){
        myArrayList myarrayList = new myArrayList();
        //验证一下尾插
        System.out.println("测试尾插Add:");
        System.out.println("顺序表起始为空表"+myarrayList);
        myarrayList.add("c");
        myarrayList.add("C++");
        myarrayList.add("java");
        myarrayList.add("python");
        System.out.println("顺序表尾插后的内容："+myarrayList);//相当于myarrayList.toString()

        //验证一下指定位置插入
        System.out.println("测试指定位置插入Add:");
        myarrayList.add(1, "javascript");
        System.out.println("在下标为1处插入新元素："+myarrayList);

        System.out.println("============================================================");
    }

    private static void testRemove(){
        myArrayList myArrayList = new myArrayList();
        System.out.println("测试删除Remove：");
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");
        System.out.println("顺序表起始内容："+myArrayList);

        myArrayList.remove(1);
        System.out.println("删除下标1处的元素："+myArrayList);

        myArrayList.remove("java");
        System.out.println("删除指定元素java："+myArrayList);

        System.out.println("============================================================");
    }


    private static void testGetAndSet() {
        myArrayList myArrayList = new myArrayList();
        System.out.println("测试Get和Set方法：");
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("python");
        System.out.println("顺序表起始内容："+myArrayList);

        System.out.println("获取下标为1处的元素："+myArrayList.get(1));
        myArrayList.set(2, "javascript");
        System.out.println("在下标为2处插入新元素："+myArrayList);
        //System.out.println("压力测试看代码是否能捕获异常："+myArrayList.get(100));

        System.out.println("============================================================");
    }

    private static void testContainsAndIndexOf() {
        myArrayList myArrayList = new myArrayList();
        System.out.println("测试Contains和IndexOf操作：");
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("c++");
        myArrayList.add("python");
        System.out.println("顺序表起始内容："+myArrayList);

        System.out.println("是否包含C++："+myArrayList.contains("c++"));
        System.out.println("从前往后遍历查找C++:"+myArrayList.indexOf("c++"));
        System.out.println("从后往前遍历查找C++:"+myArrayList.lastIndexOf("c++"));

        System.out.println("============================================================");
    }

    private static void testSizeEmptyClear() {
        myArrayList myArrayList = new myArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("java");
        myArrayList.add("c++");
        myArrayList.add("python");
        System.out.println("顺序表起始内容："+myArrayList);

        System.out.println("当前顺序表大小："+myArrayList.size());
        System.out.println("判断顺序表是否为空："+myArrayList.isEmpty());

        myArrayList.clear();
        System.out.println("清空后顺序表的大小："+myArrayList.size());
        System.out.println("清空后顺序表是否为空："+myArrayList.isEmpty());

        System.out.println("============================================================");
    }

    public static void main(String[] args) {
        testAdd();
        testRemove();
        testGetAndSet();
        testContainsAndIndexOf();
        testSizeEmptyClear();
    }
}
