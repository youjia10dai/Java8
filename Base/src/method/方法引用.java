package method;

import test.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 17:14
 * @Description:方法引用
 * 三种表现形式：
 *    1. 对象::实例方法名
 *    2. 类::静态方法名
 *    3. 类::实例方法名
 */
public class 方法引用 {

    /**
     *注意：(满足下面条件)
     *   1.引用的方法的参数列表和返回值类型要与函数式接口抽象方法保持一致!(方法名可以不同)
     *   2.若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method(搜索demo)
     */
    public static void main(String[] args) {
        // 方法引用-对象::实例方法  System.out是一个对象
        Consumer<Integer> con = (x) -> System.out.println(x);
        con.accept(100);

        Consumer<Integer> con2 = System.out::println;
        con2.accept(200);


        // 方法引用-类名::静态方法名
        BiFunction<Integer, Integer, Integer> biFun = (x, y) -> Integer.compare(x, y);

        BiFunction<Integer, Integer, Integer> biFun2 = Integer::compare;
        Integer result = biFun2.apply(100, 200);

        // 方法引用-类名::实例方法名 demo
        BiFunction<String, String, Boolean> fun1 = (str1, str2) -> str1.equals(str2);

        BiFunction<String, String, Boolean> fun2 = String::equals;
        Boolean result2 = fun2.apply("1", "world");
        System.out.println(result2);

        BiFunction<List, String, Boolean> fun3 = List<String>::contains;
    }

}
