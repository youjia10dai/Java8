package stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 16:10
 * @Description: Stream 并行流详解(默认是串型流)
 * 并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。串行流则相反，并行流的底层其实就是ForkJoin框架的一个实现。
 * java.util.Collection < E >新添加了两个默认方法
 * default Stream stream() ： 返回串行流
 * default Stream parallelStream() ： 返回并行流
 */
public class StreamBase10 {

    public static void main(String[] args) {
        // 并行流 多个线程执行
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream()
                .forEach(System.out::print);

        // 默认是串型流
        System.out.println("");
        System.out.println("=========================");
        numbers.stream().forEach(System.out::print);
    }

}
