package method;

import entity.Product;
import test.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-11 17:35
 * @Description: 构造器引用
 * 格式：ClassName::new
 */
public class MethodBase2 {

    /**
     *注意：(满足下面条件)
     *   1.引用的方法的参数列表和返回值类型要与函数式接口抽象方法保持一致!(函数名可以不同)
     *   2.若lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method(搜索demo)
     */
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


        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1,2,3,4,5);

        //lambda表达式 方法引用
        list.forEach(System.out::println);

        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11, "小牙刷", 12.05 ));
        items.add(new Item(5, "日本马桶盖", 999.05 ));
        items.add(new Item(7, "格力空调", 888.88 ));
        items.add(new Item(17, "肥皂", 2.00 ));
        items.add(new Item(9, "冰箱", 4200.00 ));

        items.removeIf(ele -> ele.getId() == 7);

        //通过 foreach 遍历，查看是否已经删除
        items.forEach(System.out::println);
    }

}
