package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 14:16
 * @Description:
 */
public class StreamBase8 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     *  归约
     *      reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        // 若Lambda表达式的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，就可以使用这种方法：
        Optional<Integer> op = products.stream()
                //product -> product.getPrice()  可以简写成 Product::getPrice  第一个参数是product,没有第二个参数
                .map(Product::getPrice)
                .reduce(Integer::sum);

        System.out.println(op.get());
    }

}
