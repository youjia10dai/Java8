package date;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 * @Author: chenlj
 * @CreateTime: 2023-04-23 14:46
 * @Description: todo
 */
public class 获取时间戳 {
    public static void main(String[] args) {
        //获取秒数
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //获取毫秒数
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println("second = " +second);
    }
}
