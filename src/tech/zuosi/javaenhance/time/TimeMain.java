package tech.zuosi.javaenhance.time;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by iwar on 2017/7/27.
 */
public class TimeMain {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(String.format("isLeapYear: %s", localDate.isLeapYear()));
        LocalTime localTime = LocalTime.now();
        System.out.println(localDate+" "+localTime);
    }
}
