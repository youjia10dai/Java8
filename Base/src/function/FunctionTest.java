package function;

import java.util.Date;
import java.util.function.Function;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-11 10:13
 * @Description: Function测试
 * 多个Function组合可以实现对象的任意转换
 */
public class FunctionTest {

    public static void main(String[] args) {
        testCompose();
        testAndThen();
    }

    /**
     * 测试Function中的Compose方法
     * Function<T, R>  接收T返回R
     * 接收的参数:<? super V, ? extends T> before   接收V 返回T
     * 返回对象: Function<V, R> 接收V 返回R
     */
    public static void testCompose() {
        Function<Long, String> firstFunction = s -> {
            return s.toString() + "1";
        };

        Function<Date, Long> secondFunction = date -> {
            return date.getTime();
        };

        Function<Date, String> compose = firstFunction.compose(secondFunction);
        // 先执行secondFunction,V变成T,在执行firstFunction,T变成R,整体而言就是V 变成 R
        String apply = compose.apply(new Date());
        System.out.println(apply);
    }

    /**
     * 测试Function中的AndThen方法
     * Function<T, R>  接收T返回R
     * 接收的参数: Function<? super R, ? extends V> after   接收R返回V
     * 返回对象:   Function<T, V>      接收 T 返回 V
     */
    public static void testAndThen() {
        Function<String, Long> firstFunction = s -> {
            return Long.parseLong(s);
        };

        Function<Long, Date> secondFunction = date -> {
            return new Date();
        };

        Function<String, Date> stringDateFunction = firstFunction.andThen(secondFunction);
        // firstFunction,T变成R,secondFunction,R变成V,整体而言就是T 变成 V
        Date date = stringDateFunction.apply("11");
        System.out.println(date);
    }

}