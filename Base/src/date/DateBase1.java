package date;

import java.time.LocalDateTime;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 16:44
 * @Description: 操作和创建时间
 */
public class DateBase1 {

    public static void main(String[] args) {
        // 从默认时区的系统时钟获取当前的日期时间。不用考虑时区差
        LocalDateTime date = LocalDateTime.now();
        //2020-09-14  T  16:44:41.472
        System.out.println(date);

        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getHour());
        System.out.println(date.getMinute());
        System.out.println(date.getSecond());
        System.out.println(date.getNano());// 纳秒值
        System.out.println(System.currentTimeMillis());

        // 手动创建一个LocalDateTime实例
        LocalDateTime date2 = LocalDateTime.of(2017, 12, 17, 9, 31, 31, 31);
        System.out.println(date2);

        // 进行加操作，得到新的日期实例
        LocalDateTime date3 = date2.plusDays(12);
        System.out.println(date3);

        // 进行减操作，得到新的日期实例
        LocalDateTime date4 = date3.minusYears(2);
        System.out.println(date4);
    }

}
