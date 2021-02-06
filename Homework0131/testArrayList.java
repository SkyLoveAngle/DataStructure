package Homework0131;
import java.util.ArrayList;
import java.util.Iterator;


public class testArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();//创建ArrayList实例
        /*
        List<String> arrayList = new ArrayList<String>();
        这段代码中，List和ArrayList实现了“向上转型操作”，即将注释释放，下面代码中的方法调用会触发动态绑定，
        通过多态的形式来执行到ArrayList中的代码。
        */
        System.out.println(arrayList.size());//顺序表长度
        System.out.println(arrayList.isEmpty());//顺序表判断是否为空表

        //1.add操作，把一个元素添加到ArrayList末尾。
        arrayList.add("C");
        arrayList.add("C++");
        arrayList.add("JAVA");
        arrayList.add("Python");
        System.out.println(arrayList.size());
        System.out.println("进行4次尾插操作后的结果："+arrayList);
        //ArrayList类重写了toString方法，所以可以直接打印。

        //2.add操作，往ArrayList指定位置上插入一个元素。
        arrayList.add(2,"JavaScript");
        System.out.println(arrayList.size());
        System.out.println("在下标为2的位置进行插入："+arrayList);

        //3.remove操作，删除ArrayList中指定位置的元素。
        arrayList.remove(2);
        System.out.println("删除下标为2位置的元素："+arrayList);

        //4.remove操作，删除Arraylist中指定值元素。
        arrayList.add("C++");
        System.out.println("往ArrayList中多加一个元素："+arrayList);
        arrayList.remove("C++");
        System.out.println("删除内容为C++的元素："+arrayList);
        //删除指定元素，如果有多个该元素，那么只删除下标最小的那个位置的，如果想全部删除，要搭配循环。
        /*
        此处删除某一指定内容的元素，肯定需要对ArrayList进行遍历操作，然后比较每个位置的值与该指定内容是否相等。
        此时判断相等的方式理论上可以有“==”和“equals”实现。但是实际上是由“equals”来实现的。
        因为ArrayList里面可以存不同类型的元素（泛型），比如存了一个你自己写的类，
        我们此时可以通过重写equals的方式，来告诉ArrayList什么叫做相等，然后实现正确的相等内容捕获，再删除。
         */

        //5.contains操作，通过遍历的方式，判断与目标元素相等的元素是否存在于线性表中，返回值是Boolean类型。
        boolean ret = arrayList.contains("JAVA");
        System.out.println("用contains查找JAVA的结果为："+ ret);

        //6.indexOf操作，按照从前往后遍历的方式，找到第一个与目标元素相等的元素的下标，返回下标位置。
        int index1 = arrayList.indexOf("JAVA");
        System.out.println("用indexOf查找JAVA的结果为："+index1);

        //7.lastIndexOf操作，按照从后往前遍历的方式，找到第一个与目标元素相等的元素的下标，返回下标位置。
        int index2 = arrayList.lastIndexOf("JAVA");
        System.out.println("用indexOf查找JAVA的结果为："+index2);

        //8.get操作，通过元素的下标位置获取该位置元素，并且返回该元素。
        String str = arrayList.get(1);
        System.out.println("获取到下标位置为1的元素："+str);

        //9.set操作，指定一个目标位置以及要修改的内容， 用新的元素替换目标位置的元素，并返回该位置的原来的元素.
        String elem = arrayList.set(0,"PHP");
        System.out.println("0号下标的元素为："+elem);
        System.out.println("修改后的顺序表为："+arrayList);


        // 10.遍历操作，三种方法：
        // a)通过下标来遍历。
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

        // b)通过迭代器来遍历。
        //先通过Iterator方法或取到迭代器对象。
        Iterator<String> iterator = arrayList.iterator();
        //再通过while循环来进行遍历.
        while(iterator.hasNext()){  //()里面是判断是否有下一个元素，如果存在返回true，不存在返回false。
            String e= iterator.next();//获取当前元素,并且“光标”指向下一个元素。
            System.out.println(e);
        }

        // c)使用for-each来遍历。（本质是基于迭代器的方式实现的）
        for (String e : arrayList){
            System.out.println(e);
        }

        //11.clear操作，清空线性表，也就是调用clear()后，线性表的size()==0；isEmpty()==true。
        arrayList.clear();
        System.out.println(arrayList);

    }
}
