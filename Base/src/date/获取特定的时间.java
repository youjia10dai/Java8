package date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 17:09
 * @Description: 获取特定的时间
 */
public class 获取特定的时间 {

    public static void main(String[] args) {
        // temperalAdjust 时间校验器
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);

        // 获取一年中的第一天
        LocalDateTime ldt2 = ldt1.withDayOfYear(1);
        System.out.println(ldt2);
        // 获取一个月中的第一天
        LocalDateTime ldt3 = ldt1.withDayOfMonth(1);
        System.out.println(ldt3);

        // 获取下一周第一天
        LocalDateTime ldt4 = ldt1.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt4);

        // 获取下一个工作日
        LocalDateTime ldt5 = ldt1.with((t) -> {
            LocalDateTime ldt6 = (LocalDateTime)t;
            DayOfWeek dayOfWeek = ldt6.getDayOfWeek();
            if (DayOfWeek.FRIDAY.equals(dayOfWeek)){
                return ldt6.plusDays(3);
            }
            else if (DayOfWeek.SATURDAY.equals(dayOfWeek)){
                return ldt6.plusDays(2);
            }
            else {
                return ldt6.plusDays(1);
            }
        });
        System.out.println(ldt5);
    }

}
