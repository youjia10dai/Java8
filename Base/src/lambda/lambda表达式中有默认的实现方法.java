package lambda;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 16:34
 * @Description: 特殊函数表达式演示(函数式接口有默认的实现方法)
 */
public class lambda表达式中有默认的实现方法 {

    public static List<Product> products;

    static{
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    public static void main(String[] args) {
        MyPredicate<Product> mp = (product) -> product.getPrice() < 8000;
        MyPredicate<Product> mp1 = (product) -> "红色".equals(product.getColor());
        System.out.println("过滤颜色" + mp.filterProductByPredicate(products));
        System.out.println("过滤价格" + mp1.filterProductByPredicate(products));
    }

    // lambda表达式有默认的实现方法
    static interface MyPredicate <T> {

        boolean test(T t);

        default List<T> filterProductByPredicate(List<T> list) {
            List<T> prods = new ArrayList<>();
            for (T prod : list){
                if (this.test(prod)){
                    prods.add(prod);
                }
            }
            return prods;
        }
    }

}
