package stream;

import entity.Product;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 15:39
 * @Description: collect 接收一个 Collector接口的实现
 *              1.将流转换为其他形式
 *              2.用于给Stream中元素做汇总的方法
 */
public class StreamBase9 {

    public static List<Product> products;

    public static void main(String[] args) {
        test7();
    }

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑色"));
    }

    /* collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法 */
    public static void test3(){
        List<String> list = products.stream()
                .map(Product::getColor)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = products.stream()
                .map(Product::getColor)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        HashSet<String> hs = products.stream()
                .map(Product::getColor)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);

        System.out.println("----------------------------------");

        //转成map,注:key不能相同，否则报错
        Map<String, Integer> studentMap = products.stream().collect(Collectors.toMap(Product::getColor, Product::getPrice)); // {cc=10, bb=20, aa=10}
        System.out.println(studentMap);
    }

    /* 获取最大值,最小值,     进行统计 */
    public static void test4(){
        // 获取最大值
        Optional<Integer> max = products.stream()
                .map(Product::getPrice)
                .collect(Collectors.maxBy(Integer::compare));

        System.out.println(max.get());

        // 获取最小值
        Optional<Product> op = products.stream()
                .collect(Collectors.minBy((e1, e2) -> Integer.compare(e1.getPrice(), e2.getPrice())));

        System.out.println(op.get());

        // 获取合
        int sum = products.stream()
                .collect(Collectors.summingInt(Product::getPrice));

        System.out.println(sum);

        // 获取平均值
        double avg = products.stream()
                .collect(Collectors.averagingInt(Product::getPrice));

        System.out.println(avg);

        // 获取总数量
        Long count = products.stream()
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");
        // 统计所有的,包含上述所有
        DoubleSummaryStatistics dss = products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
        System.out.println(dss.getMax());
    }

    //分组
    public void test5(){
        Map<String, List<Product>> map = products.stream()
                .collect(Collectors.groupingBy(Product::getColor));
        System.out.println(map);
    }

    //多级分组
    public static void test6(){
        Map<String, Map<Integer, Map<String, List<Product>>>> collect = products.stream()
                .collect(Collectors.groupingBy(Product::getColor, Collectors.groupingBy(Product::getPrice, Collectors.groupingBy((e) -> {
                    if (e.getPrice() <= 800)
                        return "老年";
                    else if (e.getPrice() <= 8000)
                        return "中年";
                    else
                        return "成年";
                }))));
        System.out.println(collect);
    }

    //分区
    public static void test7(){
        Map<Boolean, List<Product>> map = products.stream()
                .collect(Collectors.partitioningBy((e) -> e.getPrice() >= 5000));
        System.out.println(map);
    }

    // 字符串连接
    public static void test8(){
        String str = products.stream()
                .map(Product::getColor)
                .collect(Collectors.joining("," , "----", "----"));
        System.out.println(str);
    }


    //规约
    public void test9(){
        Optional<Integer> sum = products.stream()
                .map(Product::getPrice)
                .collect(Collectors.reducing(Integer::sum));
        System.out.println(sum.get());
    }


}
