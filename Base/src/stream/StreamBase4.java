package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 11:03
 * @Description: Stream的中间操作
 */
public class StreamBase4 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     * sorted()——自然排序 Comparable
     * sorted(Comparator com)——定制排序  Comparator
     */
    public static void main(String[] args) {
        products.stream()
                .map(Product::getColor)
                .sorted()//自然排序
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        // 指定排序
        products.stream()
                .sorted((x, y) -> {
                    if (x.getPrice().equals(y.getPrice())) {
                        return x.getColor().compareTo(y.getColor());
                    } else {
                        return Integer.compare(x.getPrice(), y.getPrice());
                    }
                }).forEach(System.out::println);
    }
}