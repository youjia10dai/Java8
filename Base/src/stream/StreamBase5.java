package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 11:14
 * @Description: 终止操作
 */
public class StreamBase5 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     *  查找和匹配
     *      allMatch-检查是否匹配所有元素
     *      anyMatch-检查是否至少匹配一个元素
     *      noneMatch-检查是否没有匹配所有元素
     */
    public static void main(String[] args) {
        boolean bl = products.stream()
                .allMatch((e) -> e.getColor().equals("红色"));
        System.out.println(bl);

        boolean bl1 = products.stream()
                .anyMatch((e) -> e.getColor().equals("红色"));

        System.out.println(bl1);

        boolean bl2 = products.stream()
                .noneMatch((e) -> e.getColor().equals("红色"));
        System.out.println(bl2);

    }
}