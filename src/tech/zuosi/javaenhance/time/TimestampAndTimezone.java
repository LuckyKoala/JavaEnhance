package tech.zuosi.javaenhance.time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by luckykoala on 19-3-15.
 */
public class TimestampAndTimezone {
    public static void main(String[] args) {
        instant();
        System.out.println();
        timezone();
    }

    private static void instant() {
        //错误示范 通过直接加减时间戳来获得不同时区的时间
        Instant instantPlusEightHours = Instant.now().plus(8, ChronoUnit.HOURS);
        Instant now = Instant.now();

        System.out.println("UTC:          " + now);
        System.out.println("UTC+8:        " + instantPlusEightHours);
        //实际对应UTC+8时区的时间
        System.out.println("UTC+8实际时间: " + instantPlusEightHours.atZone(ZoneId.of("UTC+8")));

        System.out.println("对应上面UTC的时间戳:    " + now.toEpochMilli());
        System.out.println("系统时间戳:            " + System.currentTimeMillis());
        System.out.println("对应上面UTC+8的时间戳:  " + instantPlusEightHours.toEpochMilli());

    }

    private static void timezone() {
        //正确方法是 通过时区与时间戳来计算时间
        Instant now = Instant.now();
        ZonedDateTime UTCplusEight = now.atZone(ZoneId.of("UTC+8"));

        System.out.println("UTC:   " + now);
        System.out.println("UTC+8: " + UTCplusEight);

        System.out.println("对应上面UTC的时间戳:   " + now.toEpochMilli());
        System.out.println("系统时间戳:           " + System.currentTimeMillis());
        System.out.println("对应上面UTC+8的时间戳: " + UTCplusEight.toInstant().toEpochMilli());
    }
}
