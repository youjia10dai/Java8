package com.royasoft;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口    无放回值
 * 		void accept(T t);
 *
 * Supplier<T> : 供给型接口    有返回值
 * 		T get();
 *
 * Function<T, R> : 函数型接口
 * 		R apply(T t);
 *
 * Predicate<T> : 断言型接口
 * 		boolean test(T t);
 *
 */
public class TestLambda3 {
    //Predicate<T> 断言型接口：
    @Test
    /**
     * 有参数返回一个boolean  断言型接口  boolean test(T t);
     */
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atguigu", "Lambda", "www", "ok");
        List<String> result = filterStr(list, (str) -> str.length() > 3);
        System.out.println(result);
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for (String str : list) {
            if(predicate.test(str)){
                result.add(str);
            }
        }
        return result;
    }

    //Function<T, R> 函数型接口：
    @Test
    /**
     * 有参数有返回值 函数型接口：  R apply(T t);
     */
    public void test3() {
        System.out.println(handleString("  a   ", (str) -> str.trim()));
    }

    //需求：用于处理字符串
    public String handleString(String str, Function<String, String> function){
        return function.apply(str);
    }

    //Supplier<T> 供给型接口 :
    @Test
    /**
     *  没有参数,有返回值  供给型接口 :  T get();
     */
    public void test2() {
        System.out.println(getRandom(() -> (int) (Math.random() * 100)));
    }

    public Integer getRandom(Supplier<Integer> supplier) {
        return supplier.get();
    }

    //需求：产生指定个数的整数，并放入集合中

    //Consumer<T> 消费型接口 :
    @Test
    /**
     * 输出一段话  消费型接口 :
     * 有参数没有返回值  void accept(T t);
     */
    public void test1() {
        printName("clj", (name) -> System.out.println("我的名字是" + name));
    }

    public void printName(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

}