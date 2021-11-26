package lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 15:15
 * @Description: lambda表达式本质上是一段匿名内部类，也可以是一段可以传递的代码
 */
public class LambdaBase1 {

    public static void main(String[] args) {

    }

    //lambda表达式本质上是一段匿名内部类
    public static void demo1() {
        Comparator<Integer> cpt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> set = new TreeSet<>(cpt);

        System.out.println("===============================================");

        Comparator<Integer> cpt2 = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> set2 = new TreeSet<>((x,y) -> Integer.compare(x,y));
    }

}
