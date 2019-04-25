package com.paper.question.common;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTimeUtil {

    private static final ZoneOffset DEFAULT_ZONE_OFFSET = ZoneOffset.of("+8");

    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("+8");

    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    public static enum Formatter {
        YYYY_MM_DD("yyyyMMdd"),

        YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),

        YYYYMMDDHHMMSS("yyyyMMddHHmmss"),
        ;

        String format;

        Formatter(String format) {
            this.format = format;
        }
    }

    /**
     * 获取当前时间戳，单位：秒，长度10位
     */
    public static long nowSecond() {
        return LocalDateTime.now().toEpochSecond(DEFAULT_ZONE_OFFSET);
    }

    /**
     * 获取当前时间戳，单位：秒，长度10位，用int类型接收
     */
    public static int nowSecond2() {
        return (int) LocalDateTime.now().toEpochSecond(DEFAULT_ZONE_OFFSET);
    }

    /**
     * 获取当前时间戳，单位：毫秒，长度13位
     */
    public static long nowMilli() {
        return LocalDateTime.now().toInstant(DEFAULT_ZONE_OFFSET).toEpochMilli();
    }

    /**
     * 获取当前年
     */
    public static int nowYear() {
        return LocalDate.now().getYear();
    }

    /**
     * 获取当前月 1 ~ 12
     */
    public static int nowMonth() {
        return LocalDate.now().getMonthValue();
    }

    /**
     * 获取当前日, 1 ~ 31
     */
    public static int nowDayOfMonth() {
        return LocalDate.now().getDayOfMonth();
    }

    /**
     * 获取当前日期时间对象
     */
    public static Date now() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(DEFAULT_ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    /**
     * 获取偏移量相对于当前日期的日期对象
     *
     * @param secondOffset 偏移量，单位为秒
     */
    public static Date getDate(long secondOffset) {
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(secondOffset);
        ZonedDateTime zdt = localDateTime.atZone(DEFAULT_ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    /**
     * 获取偏移量相对于当前日期的日期对象
     *
     * @param secondOffset 偏移量，单位为秒
     */
    public static Date offsetDate(Date date, long secondOffset) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), DEFAULT_ZONE_ID).plusSeconds(secondOffset);
        ZonedDateTime zdt = localDateTime.atZone(DEFAULT_ZONE_ID);
        return Date.from(zdt.toInstant());
    }


    /**
     * 秒为单位的时间戳转换为日期对象
     */
    public static Date fromTimestamp(int secondTimestamp) {
        Instant instant = Instant.ofEpochSecond(secondTimestamp);
        return Date.from(instant);
    }

    /**
     * 获取秒级时间戳
     */
    public static long getTimestamp(Date date) {
        long time = date.getTime();
        return time / 1000;
    }

    /**
     * 获取当前日期的格式化字符串结果
     */
    public static String now(Formatter formatter) {
        SimpleDateFormat sdf = DATE_FORMAT_THREAD_LOCAL.get();
        sdf.applyPattern(formatter.format);
        return sdf.format(now());
    }

    /**
     * 按照指定模式格式化日期对象
     */
    public static String format(Date date, Formatter formatter) {
        SimpleDateFormat sdf = DATE_FORMAT_THREAD_LOCAL.get();
        sdf.applyPattern(formatter.format);
        return sdf.format(date);
    }

    /**
     * 计算两个日期想相差的天数
     *
     * @param begin 开始日期（包含）
     * @param end   结束日期（不包含）
     * @return 相差的天数
     */
    public static int offsetDays(LocalDate begin, LocalDate end) {
        // 实际用不到long存放结果
        return (int) begin.until(end, ChronoUnit.DAYS);
    }

}
