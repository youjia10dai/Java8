package stream;

import entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 10:23
 * @Description: Stream的中间操作
 */
public class StreamBase3 {

    public static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(8001, "红色"));
        products.add(new Product(800, "黑丝"));
    }

    /**
     *  映射
     *      map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     *      flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    public static void main(String[] args) {
        products.stream()
                .map((e) -> e.getColor())
                .forEach(System.out::println);
        System.out.println("-------------------------------------------");
        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        // 若Lambda表达式的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，就可以使用这种方法：
        Stream<String> stream = strList.stream()
                //string -> string.toUpperCase()  可以简写成 String::toUpperCase  string,没有第二个参数
                .map(string->string.toUpperCase());
        stream.forEach(System.out::println);
        System.out.println("---------------------------------------------");
        // 将元素转换成stream
        Stream<Stream<Character>> stream2 = strList.stream()
                .map(StreamBase3::filterCharacter);
        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });
        System.out.println("---------------------------------------------");
        // 将元素转换成流,最后将所有的流转化成一个流
        Stream<Character> stream3 = strList.stream()
                .flatMap(StreamBase3::filterCharacter);
        stream3.forEach(System.out::println);
    }
    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

}