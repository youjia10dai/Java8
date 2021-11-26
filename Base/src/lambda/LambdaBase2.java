package lambda;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 15:39
 * @Description:
 */
public class LambdaBase2 {

    public static List<Product> products;

    static{
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    public static void main(String[] args) {
        // 使用最原始的
        System.out.println("过滤颜色" + filterProductByColor(LambdaBase2.products));
        System.out.println("过滤价格" + filterProductByPrice(LambdaBase2.products));

        // 优化1: 使用设计模式.               new ColorPredicate() 相关于是处理对象
        System.out.println("过滤颜色" + filterProductByPredicate(LambdaBase2.products, new ColorPredicate()));
        System.out.println("过滤价格" + filterProductByPredicate(LambdaBase2.products, new PricePredicate()));

        // 优化2: 使用匿名内部类的方式
        filterProductByPredicate(LambdaBase2.products, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return "红色".equals(product.getColor());
            }
        });

        filterProductByPredicate(LambdaBase2.products, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getPrice() < 8000;
            }
        });

        // 优化3:  使用lambda表达式
        System.out.println("过滤颜色" +filterProductByPredicate(LambdaBase2.products, (product) -> "红色".equals(product.getColor())));
        System.out.println("过滤价格" +filterProductByPredicate(LambdaBase2.products, (product) -> product.getPrice() < 8000));
    }

    // 这样一个场景，在商城浏览商品信息时，经常会有条件的进行筛选浏览，例如要选颜色为红色的、价格小于8000千的….
    // 筛选颜色为红色
    public static List<Product> filterProductByColor(List<Product> list){
        List<Product> prods = new ArrayList<>();
        for (Product product : list){
            if ("红色".equals(product.getColor())){
                prods.add(product);
            }
        }
        return prods;
    }

    // 筛选价格小于8千的
    public static List<Product> filterProductByPrice(List<Product> list){
        List<Product> prods = new ArrayList<>();
        for (Product product : list){
            if (product.getPrice() < 8000){
                prods.add(product);
            }
        }
        return prods;
    }

    // 优化一：使用设计模式
    static interface MyPredicate <T> {
        boolean test(T t);
    }

    static class ColorPredicate implements MyPredicate <Product> {
        private static final String RED = "红色";
        @Override
        public boolean test(Product product) {
            return RED.equals(product.getColor());
        }
    }

    static class PricePredicate implements MyPredicate<Product> {
        @Override
        public boolean test(Product product) {
            return product.getPrice() < 8000;
        }
    }

    public static List<Product> filterProductByPredicate(List<Product> list, MyPredicate<Product> mp){
        List<Product> prods = new ArrayList<>();
        for (Product prod : list){
            if (mp.test(prod)){
                prods.add(prod);
            }
        }
        return prods;
    }

}
