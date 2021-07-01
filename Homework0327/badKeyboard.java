package Homework0327;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class badKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1. 读取两个字符串
            // 预期要打印的结果(比较长, 完整的)
            String excepted = scanner.next();
            // 实际打印的结果(比较短, 残缺的)
            String actual = scanner.next();
            // 2. 由于大小写是同一个按键, 下面的逻辑要忽略大小写
            // 把这两个字符串都统一转成大写形式
            excepted = excepted.toUpperCase();
            actual = actual.toUpperCase();
            // 3. 题目的核心要求, 需要找到哪些字符在 excepted 中存在
            //    然后在 actual 中不存在
            //    为了实现这个效果, 就先搞一个 Set, 用这个 Set 记录下 actual 里都有哪些字符
            //    再遍历 excepted, 看这里面的哪些字符在 Set 中不存在就好了
            Set<Character> actualSet = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                actualSet.add(actual.charAt(i));
            }
            // 遍历 excepted 这个字符串, 看当前字符是否在 actualSet 中存在
            // 不存在则说明这是个坏了的键
            Set<Character> brokenSet = new HashSet<>();
            for (int i = 0; i < excepted.length(); i++) {
                char c = excepted.charAt(i);
                if (actualSet.contains(c)) {
                    // 说明 c 已经被实际输出了, 一定不是坏了的键!!
                    continue;
                }
                // 说明 c 这个字符对应的键已经是坏了的键了
                // 输出坏键. 但是此处最好别直接输出.
                // 直接输出可能会有重复结果
                // 再使用一个 Set , 记录当前哪些键已经是坏键被输出过了.
                // 如果输出过了, 就不再输出了
                if (brokenSet.contains(c)) {
                    // 如果 c 已经被记为坏键了, 就直接跳过.
                    continue;
                }
                // 如果 c 没有被记为坏键, 就输出, 并记为坏键
                System.out.print(c);
                brokenSet.add(c);
            }
            // 此处再输出一个换行, 保证每组用例的结果都是独占一行的
            System.out.println();
        }
    }
}
