package Homework0327;

import java.util.HashMap;
import java.util.Map;

public class testMap {
    public static void main(String[] args) {
        Map<String ,String> map = new HashMap<>();
        // 1. 使用 put 方法插入键值对
        map.put("及时雨", "宋江");
        map.put("黑旋风", "李逵");
        map.put("行者", "武松");
        map.put("及时雨", "宋公明");
        map.put("小李广", "花荣本荣");
        System.out.println(map);

        //2.使用get方法，根据key值获取value
        String value1 = map.get("行者");
        String value2 = map.get("小李广");
        System.out.println(value1 +"  "+ value2);

        //3.使用getOrDefault方法，根据key值获取value，如果key不存在，返回默认值
        String value3 = map.getOrDefault("小李广","花荣（默认值）");
        String value4 = map.getOrDefault("豹子头"," 林冲（默认值）");
        System.out.println(value3+" "+value4);

        // 4. 使用 isEmpty 判定空
        System.out.println("判断Map是否为空？："+map.isEmpty());
        // 5. 使用 size 获取到键值对的个数
        System.out.println("获取Map的大小："+map.size());
        // 6. 使用 clear 清空所有的键值对
        map.clear();
        System.out.println("使用clear()后判断Map是否为空？："+map.isEmpty());
        System.out.println("使用clear()后获取Map的大小："+map.size());

         //7. 遍历 Map (Map 设计出来不是为了遍历!!)
           // 遍历 Map 是比较复杂的, 需要把 Map 转换成 Set 再遍历
        System.out.println("遍历Map，将键值对打印输出：");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
         //8. 还可以单独的获取到所有的 key 和所有的 value
        System.out.println("打印输出所有的key：");
        for (String key : map.keySet()) {
            System.out.print(key+" ");
        }
        System.out.println("\n"+"打印输出所有的value:");
        for (String value : map.values()) {
            System.out.print(value+" ");
        }
    }
}
