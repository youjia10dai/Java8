package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 11:31
 * @Description: 终止操作
 */
public class StreamBase7 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     *  查找和匹配
     *      count-返回流中元素的总个数
     *      max-返回流中最大值
     *      min-返回流中最小值
     */
    public static void main(String[] args) {
        long count = products.stream()
                .filter((e) -> e.getColor().equals("红色"))
                .count();

        System.out.println(count);

        Optional<Integer> op = products.stream()
                .map(Product::getPrice)
                .max(Integer::compare);

        System.out.println(op.get());

        Optional<Product> op2 = products.stream()
                .min((e1, e2) -> Integer.compare(e1.getPrice(), e2.getPrice()));
        System.out.println(op2.get());
    }
}
