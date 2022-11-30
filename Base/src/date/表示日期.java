package date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: chenlj
 * @CreateTime: 2022-11-30 15:17
 * @Description: todo
 */
public class 表示日期 {
    public static void main(String[] args) {
        //获取当前日期,只含年月日 固定格式 yyyy-MM-dd    2018-05-04
        LocalDate today = LocalDate.now();
        // 根据年月日取日期，5月就是5，
        LocalDate oldDate = LocalDate.of(2018, 5, 1);
        System.out.println("oldDate = " +oldDate);
        // 根据字符串取：默认格式yyyy-MM-dd，02不能写成2
        LocalDate yesteday = LocalDate.parse("2018-05-03");
        System.out.println("yesteday = " +yesteday);
        // 如果不是闰年 传入29号也会报错
        LocalDate.parse("2000-02-29");

        //2018-05-04
        // 取本月第1天： 2018-05-01
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("firstDayOfThisMonth = " +firstDayOfThisMonth);
        // 取本月第2天：2018-05-02
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        System.out.println("secondDayOfThisMonth = " +secondDayOfThisMonth);
        // 取本月最后一天，再也不用计算是28，29，30还是31： 2018-05-31
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("lastDayOfThisMonth = " +lastDayOfThisMonth);
        // 取下一天：2018-06-01
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        System.out.println("firstDayOf2015 = " + firstDayOf2015);
        // 取2018年10月第一个周三 so easy?：  2018-10-03
        LocalDate thirdMondayOf2018 = LocalDate.parse("2018-10-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY));
        System.out.println("thirdMondayOf2018 = " + thirdMondayOf2018);
    }
}
