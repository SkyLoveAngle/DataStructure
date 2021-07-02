package testIO;

import org.junit.Test;

import java.io.*;

public class test_ObjectStream {
    @Test
    //序列化过程，将内存中的java对象保存到磁盘中或通过网络传输出去~~
    public void test_ObjectOutputStream(){
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\Object.data");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(new String("Welcom to the new world!"));
//            objectOutputStream.flush();
            objectOutputStream.writeObject(new Person("张三",23,true));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //反序列化过程
    public void test_ObjectInputStream(){
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\Object.data");
            objectInputStream = new ObjectInputStream(fileInputStream);

//            Object object = objectInputStream.readObject();
//            String str = (String)object;
//            System.out.println(str);
            Person person = (Person)objectInputStream.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
