package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2024-11-07 10:31
 * @Description: todo
 */
public class Test {


    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date");

        // 使用Lambda表达式对列表进行排序
        fruits.sort((a,  b) -> Integer.compare(a.length(), b.length()));
        System.out.println(fruits);  // 输出：[date, apple, cherry, banana]
    }

}
