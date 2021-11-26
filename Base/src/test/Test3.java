package test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
        Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println(v);   // 300
        Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println(v1);  //310
        Integer v2 = list.stream().reduce(0,
                (x1, x2) -> {
                    System.out.println("stream accumulator: x1:" + x1 + "  x2:" + x2);
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("stream combiner: x1:" + x1 + "  x2:" + x2);
                    return x1 * x2;
                });
        System.out.println(v2); // -300
        Integer v3 = list.parallelStream().reduce(0,
                (x1, x2) -> {
                    System.out.println("线程名称 = " + Thread.currentThread().getName());
                    System.out.println("parallelStream accumulator: x1:" + x1 + "  x2:" + x2);
                    System.out.println("结果为" + (x1 - x2));
                    return x1 - x2;
                },
                (x1, x2) -> {
                    System.out.println("线程名称 = " + Thread.currentThread().getName());
                    System.out.println("parallelStream combiner: x1:" + x1 + "  x2:" + x2);
                    System.out.println("结果为" + (x1 * x2));
                    return x1 * x2;
                });
        System.out.println(v3); //197474048
    }
}