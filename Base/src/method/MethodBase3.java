package method;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 17:41
 * @Description: 数组引用
 * 格式：Type[]::new
 */
public class MethodBase3 {

    public static void main(String[] args) {
        // 数组引用
        Function<Integer, String[]> fun = (x) -> new String[x];

        Function<Integer, String[]> fun2 = String[]::new;
        String[] strArray = fun2.apply(10);

        Arrays.stream(strArray).forEach(System.out::println);
    }

}
