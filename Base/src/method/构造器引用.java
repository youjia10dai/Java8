package method;

import entity.Product;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 17:35
 * @Description: 构造器引用
 * 格式：ClassName::new
 */
public class 构造器引用 {

    public static void main(String[] args) {
        // 构造方法引用  类名::new
        Supplier<Product> sup = () -> new Product();
        System.out.println(sup.get());

        Supplier<Product> sup2 = Product::new;
        System.out.println(sup2.get());

        // 构造方法引用 类名::new （带一个参数）
        Function<Integer, Product> fun = (x) -> new Product(x);

        Function<Integer, Product> fun2 = Product::new;
        System.out.println(fun2.apply(100));
    }

}
