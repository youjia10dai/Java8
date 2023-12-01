package date;

import java.time.LocalTime;

/**
 * @Author: chenlj
 * @CreateTime: 2022-11-30 15:16
 * @Description:
 */
public class 表示时间 {
    public static void main(String[] args) {
        //16:25:46.448(纳秒值)
        LocalTime todayTimeWithMillisTime = LocalTime.now();
        System.out.println("todayTimeWithMillisTime = " + todayTimeWithMillisTime);
        //16:28:48 不带纳秒值
        LocalTime todayTimeWithNoMillisTime = LocalTime.now().withNano(0);
        System.out.println("todayTimeWithNoMillisTime = " + todayTimeWithNoMillisTime);
        LocalTime time1 = LocalTime.parse("23:59:59");
        System.out.println("time1 = " + time1);

    }
}