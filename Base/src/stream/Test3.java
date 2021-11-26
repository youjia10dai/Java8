package stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a,b,c", "1,2,3");
        //将String类型映射成Integer类型
        Stream<Integer> s1 = list.stream().map(s -> {
            try {
                return Integer.parseInt(s.replaceAll(",", ""));
            } catch (NumberFormatException e) {
                return 110;
            }
        });
        // 110  123
        s1.forEach(System.out::println);
        Stream<String> s3 = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        // a b c 1 2 3
        s3.forEach(System.out::println);
    }
}