package date;

import java.time.*;

/**
 * @Author: chenlj
 * @CreateTime: 2020-09-14 16:58
 * @Description:
 */
public class 计算时间差 {

    public static void main(String[] args) {
        // Duration:计算两个时间之间的间隔,间隔几秒
        // Period：计算两个日期之间的间隔,间隔几年,几个月,几天

        Instant ins1 = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration dura = Duration.between(ins1, ins2);
        System.out.println(dura);
        System.out.println(dura.toMillis());

        System.out.println("======================");
        LocalTime localTime = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime2 = LocalTime.now();
        Duration du2 = Duration.between(localTime, localTime2);
        System.out.println(du2);
        System.out.println(du2.toMillis());

        System.out.println("======================");
        LocalDate localDate =LocalDate.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDate localDate2 = LocalDate.of(2016,12,12);
        Period pe = Period.between(localDate, localDate2);
        System.out.println(pe);
    }

}
