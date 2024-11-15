package stream;

import java.util.stream.IntStream;

public class IntStreamExample {
    public static void main(String[] args) {
        // 创建一个 IntStream 从 1 到 10
        IntStream.rangeClosed(1, 10)
                 .filter(n -> n % 2 == 0) // 过滤出偶数
                 .map(n -> n * n) // 平方
                 .forEach(System.out::println); // 打印结果
    }
}