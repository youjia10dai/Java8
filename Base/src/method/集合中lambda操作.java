package method;

import test.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chenlj
 * @CreateTime: 2022-11-30 17:14
 * @Description: todo
 */
public class 集合中lambda操作 {
    public static void main(String[] args) {
        遍历集合();
        删除集合中的某个元素();
        遍历Map();
    }

    public static void 遍历集合(){
        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1,2,3,4,5);

        //lambda表达式 方法引用
        list.forEach(System.out::println);

        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });
    }

    public static void 删除集合中的某个元素(){
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

    public static void 遍历Map(){
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);
        map.put("E", 50);
        map.put("F", 60);
        map.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        map.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }

}