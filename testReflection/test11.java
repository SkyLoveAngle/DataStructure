package testReflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class test11 {
    public void test01 (Map<String,User> map, List<User> list){
        System. out. println("test01");
    }
    public Map<String,User> test02(){
        System. out . println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //首先，获取方法，通过该方法获取泛型的参数化类型
        Method method = test11.class.getMethod("test01", Map.class, List.class) ;
        Type[] genericParameterTypes = method.getGenericParameterTypes() ;
        for (Type genericParameterType : genericParameterTypes){
            System.out.println("test01泛型参数类型："+ genericParameterType);
            //判断是不是一个参数化类型，是，就进行强转成参数化类型
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments){
                    System.out.println("test01泛型参数信息："+actualTypeArgument);
                }
            }
        }

        method = test11.class.getMethod("test02", null);
        Type genericParameterType = method.getGenericReturnType();
        if (genericParameterType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments){
                System.out.println("test02泛型参数信息："+actualTypeArgument);
            }
        }
    }


    }
