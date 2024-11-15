package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
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
     *  计算
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
                // Comparator.comparingInt返回的是比较器,调用这个比较器的compare方法时,里面会调用Product::getPrice进行元素的转换
                .min(Comparator.comparingInt(Product::getPrice));
        System.out.println(op2.get());
        //    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        //        Objects.requireNonNull(keyExtractor);
        //        return (Comparator<T> & Serializable)
        //            (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
        //    }
        Optional<Product> op3 = products.stream()
                .min((e1, e2) -> Integer.compare(e1.getPrice(), e2.getPrice()));
        System.out.println(op3.get());
    }
}
