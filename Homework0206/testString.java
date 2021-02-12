package Homework0206;

import java.util.Arrays;

public class testString {
    public static void main(String[] args) {
        /*
        StringBuffer的初始化！！！
         */
        //这样初始化出的StringBuffer对象是一个空的对象。
        StringBuffer stringBuffer1 = new StringBuffer();
        //分配了长度512字节的字符缓冲区。
        StringBuffer stringBuffer2 = new StringBuffer(512);
        //创建带有内容的StringBuffer对象，在字符缓冲区中存放字符串“Hello World！”。
        StringBuffer stringBuffer3 = new StringBuffer("Hello World!");
        System.out.println("打印输出stringBuffer3:"+stringBuffer3);

        /*
        append(boolean b)方法:
        该方法的作用是追加内容到当前StringBuffer对象的末尾，类似于字符串的连接，
        调用该方法以后，StringBuffer对象的内容也发生改变。
         */
        stringBuffer3.append(" Welcome!");
        System.out.println("append( “Welcome！)”后打印输出stringBuffer3:："+stringBuffer3);

        /*
        deleteCharAt(int index)方法:
        该方法的作用是删除指定位置的字符，然后将剩余的内容形成新的字符串。
         */
        stringBuffer3.deleteCharAt(11);
        System.out.println("删除下标位置为11的元素后打印输出："+stringBuffer3);

        /*
        delete(int start,int end)方法:
        该方法的作用是删除指定区间以内的所有字符，包含start，不包含end索引值的区间。
         */
        stringBuffer3.delete(5,11);
        System.out.println("删除下标位置为5-10的元素后打印输出："+stringBuffer3);

        /*
        insert(int offset, boolean b)方法：
        该方法的作用是在StringBuffer对象中插入内容，然后形成新的字符串。
         */
        stringBuffer3.insert(5," World!");
        System.out.println("在下标位置为5的地方插入“World!”后打印输出："+stringBuffer3);

        /*
        reverse()方法:
        该方法的作用是将StringBuffer对象中的内容反转，然后形成新的字符串。
         */
        stringBuffer3.reverse();
        System.out.println("将stringBuffer3内容翻转后打印输出："+stringBuffer3);

    }
}
//        String str = " Hello World! " ;
//        System.out.println("将str打印输出："+"["+str+"]");
//        System.out.println("去除str左右空格，打印输出："+"["+str.trim()+"]");
//
//        System.out.println("将str全部转换成大写，输出："+str.toUpperCase());
//        System.out.println("将str全部转换成小写，输出："+str.toLowerCase());
//
//        System.out.println("将str的长度打印输出："+str.length());
//
//        System.out.println("判空操作："+"hello".isEmpty());
//        System.out.println("判空操作："+"".isEmpty());
//        System.out.println("判空操作："+new String().isEmpty());
//
//        System.out.println("自己实现首字母大写："+fistUpper("hello!"));
//    }
//    public static String fistUpper(String str) {
//        if ("".equals(str)||str==null) {
//            return str ;
//        }
//        if (str.length()>1) {
//            return str.substring(0, 1).toUpperCase()+str.substring(1) ;
//        }
//        return str.toUpperCase() ;
//    }
//}


//        String str = "Hello_World!" ;
//        System.out.println("从下标为5的位置截取："+str.substring(5));
//        System.out.println("截取下标从0到5位置的内容："+str.substring(0, 5));
//    }
//}


//        String str = "HelloWorld!Welcom!" ;
//        String[] result1 = str.split("!") ;
//        System.out.println("按照！对字符串进行拆分：");
//        for(String s: result1) {
//            System.out.println(s);
//        }
//        System.out.println("按照l对字符串进行拆分：");
//        String[] result2 = str.split("l",5) ;
//        for(String t: result2) {
//            System.out.println(t);
//        }
//
//        String str1 = "192.168.1.1" ;
//        System.out.println("拆分IP地址：");
//        String[] result = str1.split("\\.") ;
//        for(String s: result) {
//            System.out.println(s);
//        }
//
//        String str2 = "name=zhangsan&age=18";
//        System.out.println("实现多次拆分：");
//        String[] result3 = str2.split("&") ;
//        for (int i = 0; i < result3.length; i++) {
//            String[] temp = result3[i].split("=") ;
//            System.out.println(temp[0]+" = "+temp[1]);
//        }
//    }
//}


//        String str = "Hello World!" ;
//        System.out.println("全部目标元素替换："+str.replaceAll("l", "_"));
//        System.out.println("替换找到的第一个目标元素："+str.replaceFirst("l", "_"));
//
//    }
//}


//        String str = "Hello World!" ;
//
//        System.out.println("判断是否包含World子字符串："+str.contains("World"));
//
//        System.out.println("查找字符，返回索引："+str.indexOf("World"));
//        System.out.println("查找字符，返回索引："+str.indexOf("Welcom"));
//        if (str.indexOf("Hello") != -1) {
//            System.out.println("可以查到指定字符串！");
//        }
//
//        System.out.println("从前往后查找字符，返回索引："+str.indexOf("l"));
//        System.out.println("从前往后，在指定位置往后查找字符："+str.indexOf("l",5));
//        System.out.println("从后往前，查找字符，返回索引："+str.lastIndexOf("l"));
//        System.out.println("从后往前，在指定位置往前查找字符："+str.lastIndexOf("W",9));
//
//        System.out.println("判断是否以H开头："+str.startsWith("H"));
//        System.out.println("从下标6开始判断是否以W开头："+str.startsWith("W",6));
//        System.out.println("判断是否以！结尾："+str.endsWith("!"));
//
//    }
//}



//        String str1 = "hello" ;
//        String str2 = "Hello" ;
//        System.out.println(str1.equals(str2));
//        System.out.println(str1.equalsIgnoreCase(str2));
//
//        System.out.println("A".compareTo("a"));
//        System.out.println("a".compareTo("A"));
//        System.out.println("A".compareTo("A"));
//        System.out.println("AB".compareTo("AC"));
//        System.out.println("刘".compareTo("杨"));
//    }
//}


//        String str = "Hello World!" ;
//        byte[] data = str.getBytes();
//        System.out.println("将字符串转换成data字节数组：");
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i]+"，");
//        }
//        System.out.println("\n");
//        String str1 = new String(data);
//        System.out.println("将data字节数组转换成字符串："+str1);
//    }
//}


//        String str1 = new String("Hello World!");
//        char[] arr1 = new char[]{'W','e','l','c','o','m','!'};
//
//        String str2 = new String(arr1);
//        System.out.println("将arr1数组所有元素转为字符串："+str2);
//
//        String str3 = new String(arr1,0,7);
//        System.out.println("从arr1数组的下标为0位置开始，取7个元素，组成字符串："+str3);
//
//        char ch = str1.charAt(6);
//        System.out.println("获取str1下标为6位置的元素："+ch);
//
//        char[] arr2 = str1.toCharArray();
//        System.out.print("将字符串str1变成字符数组：");
//        for (int i=0;i<arr2.length;i++){
//            System.out.print(arr2[i]+",");
//        }
//    }

