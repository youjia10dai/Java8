package stream;

import entity.Product;
import java.util.ArrayList;
import java.util.Comparator;
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
                .sorted()// 默认排序,流中的元素已经是字符串,根据颜色排序
                .forEach(System.out::println);
        System.out.println("------------------------------------");
        // 指定排序(自己实现一个比较器)
        products.stream()
                .sorted((x, y) -> {
                    if (x.getPrice().equals(y.getPrice())) {
                        return x.getColor().compareTo(y.getColor());
                    } else {
                        return Integer.compare(x.getPrice(), y.getPrice());
                    }
                }).forEach(System.out::println);
        // Comparator.comparing方法返回一个Comparator比较器,他的参数是Function,并且返回值,实现Comparable<String>
        // comparing返回的实现是一个比较器,接受两个参数,会将两个参数转换之后在比较(相当于内部类有了成员变量)
        // 用商品的颜色去比较
        products.stream()
                .sorted(Comparator.comparing(Product::getColor)).forEach(System.out::println);
        //    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
        //            Function<? super T, ? extends U> keyExtractor)
        //    {
        //        Objects.requireNonNull(keyExtractor);
        //        return (Comparator<T> & Serializable)
        //            (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
        //    }

        // 默认排序(Product进行排序),流中的元素必须是可比较的,这里会报错
        products.stream()
                .sorted().forEach(System.out::println);
    }
}