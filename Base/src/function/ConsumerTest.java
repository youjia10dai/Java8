package function;

import java.util.function.Consumer;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-11 09:46
 * @Description: Consumer接口测试
 */
public class ConsumerTest {
    public static void main(String[] args) {
        testAndThen();
    }
    /**
     * 测试Consumer中的andThen方法
     * 调用链
     */
    public static void testAndThen() {
        // 使用lambda表达式,匿名函数实现
        Consumer<String> firstConsumer = (x) -> {
            System.out.println(x + "1");
        };
        Consumer<String> secondConsumer = (x) -> {
            System.out.println(x + "2");
        };
        Consumer<String> threeConsumer = (x) -> {
            System.out.println(x + "3");
        };
        Consumer<String> stringConsumer = firstConsumer.andThen(secondConsumer).andThen(threeConsumer);
        // 效果:依次执行firstConsumer,secondConsumer,threeConsumer的accept方法
        // 原理解析:每次调用一次andThen就会返回一个新的实现对象
        // firstConsumer.andThen(secondConsumer) 返回一个对象R, R的accept方法会先调用firstConsumer的accept方法,再调用secondConsumer的accept方法
        // R.andThen(threeConsumer),就会先调用R.accept方法(就是firstConsumer和secondConsumer的accept方法),在调用threeConsumer的accept方法

        // 调用
        stringConsumer.accept("111");
    }
}