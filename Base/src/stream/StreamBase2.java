package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 10:12
 * @Description: Stream的中间操作
 */
public class StreamBase2 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     *  筛选与切片
     *      filter——接收 Lambda ， 从流中排除某些元素。
     * 		limit——截断流，使其元素不超过给定数量。
     * 		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     * 		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     */
    public static void main(String[] args) {
        /**
         * 筛选 过滤  去重
         */
        products.stream()
                .filter(e -> e.getPrice() > 10)
                .limit(4)
                .skip(1)
                // 需要流中的元素重写hashCode和equals方法
                .distinct()
                .forEach(System.out::println);
    }

}
