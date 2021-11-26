package date;

import java.time.LocalDate;

/**
 * @Author: chenlj
 * @CreateTime: 2021-03-10 16:15
 * @Description: todo
 */
public class 新日期对象不可变 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate second = now.plusDays(4);
        System.out.println(now);
        System.out.println(second);
    }
}
