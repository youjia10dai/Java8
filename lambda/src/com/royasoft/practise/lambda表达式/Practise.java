package com.royasoft.practise.lambda表达式;

import com.royasoft.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2019-12-13 15:57
 * @Description: todo
 */
public class Practise {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    /**
     * 集合排序,先按年龄排序,在按名字排序
     */

    @Test
    public void test1() {
        Collections.sort(emps, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return x.getAge() - y.getAge();
            }
        });
    }

    /**
     * 实现字符串的去除空格,字符串的截取,变成大写
     */
    @Test
    public void test2() {
        String str1 = strHandler("   wqwe   ", x -> x.trim());
        System.out.println(str1);
        String str2 = strHandler("   wqwe   ", x -> x.substring(2, 5));
        System.out.println(str2);
        String str3 = strHandler("   wqwe   ", x -> x.toUpperCase());
        System.out.println(str3);
    }

    public String strHandler(String string, StringFunction function) {
        return function.strHandle(string);
    }

    /**
     * 实现类型Long类型的相加和相减
     */
    @Test
    public void test3() {
        Long long1 = longHandler(1L, 3L, (x, y) -> x + y);
        System.out.println(long1);
        Long long2 = longHandler(1L, 3L, (x, y) -> x * y);
        System.out.println(long2);
    }

    public Long longHandler(Long first, Long second, LongFunction function) {
        return function.longHandle(first, second);
    }

}