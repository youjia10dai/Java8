package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 11:30
 * @Description: 终止操作
 */
public class StreamBase6 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     *  查找和匹配
     *      findFirst-返回第一个元素
     *      findAny-返回当前流中的任意元素
     */
    public static void main(String[] args) {
        Optional<Product> op = products.stream()
                .sorted((e1, e2) -> Double.compare(e1.getPrice(), e2.getPrice()))
                .findFirst();
        System.out.println(op.get());
        System.out.println("--------------------------------");
        // 并行流会随机返回一个(先要返回一个并行流)
        Optional<Product> op2 = products.parallelStream()
                .filter((e) -> e.getColor().equals("红色"))
                .findAny();
        System.out.println(op2.get());
    }

}
