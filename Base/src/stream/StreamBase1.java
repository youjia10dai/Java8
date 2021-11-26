package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 17:53
 * @Description: 创建stream
 */
public class StreamBase1 {

    public static void main(String[] args) {
        // 1，校验通过Collection 系列集合提供的stream()或者paralleStream()
        List<String> list = new ArrayList<>();
        list.add("1");
        Stream<String> stream1 = list.stream();
        System.out.println("stream1开始");
        stream1.forEach(System.out::println);

        // 2.通过Arrays的静态方法stream()获取数组流
        String[] str = new String[10];
        Stream<String> stream2 = Arrays.stream(str);
        System.out.println("stream2开始");
        stream2.forEach(System.out::println);

        // 3.通过Stream类中的静态方法of
        Stream<String> stream3 = Stream.of("aa","bb","cc");
        System.out.println("stream3开始");
        stream3.forEach(System.out::println);

        // 4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0,(x) -> x+2);
        System.out.println("stream4开始");
//        stream4.forEach(System.out::println);

        //4. 创建无限流(限制10个)
        //迭代  0   2   4    6   8   10
        Stream<Integer> stream5 = Stream.iterate(0, (x) -> x + 2).limit(10);
        System.out.println("stream5开始");
        stream5.forEach(System.out::println);

        //生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        System.out.println("generate开始");
        generate.forEach(System.out::println);
    }

}
