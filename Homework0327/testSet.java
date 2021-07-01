package Homework0327;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class testSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 1. 使用 add 插入元素
        set.add("C");
        set.add("C++");
        set.add("C++");
        set.add("Java");
        set.add("Python");
        System.out.println(set);

        //2. 使用 contains 方法判定元素是否存在 [重要]
        boolean ret1 = set.contains("java");
        boolean ret2 = set.contains("Java");
        System.out.println("判断是否包含java："+ret1);
        System.out.println("判断是否包含Java："+ret1);

        // 3. 使用 remove 删除元素
        set.remove("Java");
        System.out.println("删除Java后的Set："+set);

        // 4. 使用 isEmpty 来判定空
        System.out.println("判断Set是否为空："+set.isEmpty());

        // 5. 使用 size 获取元素个数
        System.out.println("获取Set中元素个数："+set.size());

        // 6. 使用 clear 清空元素
        set.clear();
        System.out.println("使用clear()后判断是否为空："+set.isEmpty());
        System.out.println("使用clear()后获取Set中元素个数："+set.size());

         // 7. 遍历
         // a) 直接使用 for-each 遍历 [语法糖]
        System.out.println("使用for-each循环遍历：");
        for (String key : set) {
            System.out.print(key+" ");
        }
        //  b) 使用迭代器来遍历
        Iterator<String> it = set.iterator();
        System.out.println("\n"+"使用迭代器循环遍历：");
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
    }
}
