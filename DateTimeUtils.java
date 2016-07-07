package com.anyo.driver.tool.DateTimeUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期时间处理工具
 */
public class DateTimeUtils {


    /**
     * 将YYYY-MM-dd EEEE格式的时间转化为年月日
     *
     * @param time
     * @return 返回年月日
     */
    public static int[] stringArrayToDate(String time) {
        if (!time.isEmpty()) {
            time = time.split(" ")[0];
        }
        return stringToDate(time);
    }

    /**
     * 将YYYY-MM-dd 格式的时间转化为年月日
     *
     * @param time
     * @return 返回年月日
     */
    public static int[] stringToDate(String time) {
        if (time.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            time = sdf.format(new Date());
        }
        int[] date = new int[3];
        for (int i = 0; i < 3; i++) {
            date[i] = Integer.parseInt(time.split("-")[i]);
        }
        return date;
    }

    /**
     * 根据日期计算星期
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String dateToString(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return year + "-" + month + "-" + day + " " + getWeek(c.get(Calendar.DAY_OF_WEEK));
    }

    /**
     * 根据日期计算星期
     *
     * @param year
     * @param month
     * @param day
     * @return 1, 2, 3, 4, 5, 6, 7
     */
    public static int dateToString2(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 将Data转化为YYYYMMDD格式的字符串
     */
    public static String getDataString(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return sdf.format(data);

    }

    /**
     * 将Data转化为MM月DD日格式的字符串
     */
    public static String getDataStringChinese(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        int[] arr = stringToDate(sdf.format(data));
        return arr[1] + "月" + arr[2] + "日";

    }

    /**
     * 获取YYYYMMdd HHmmss格式时间
     *
     * @param date YYYYMMdd HHmmss
     * @return
     */
    public static String getDataAndTime(Date date) {
        String string = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        return string;
    }

    /**
     * 将Data转化为MM月DD日格式的字符串(前一周)
     */
    public static String getDataStringChineseAWeekAgo(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        int[] arr = stringToDate(sdf.format(data));
        return arr[1] + "月" + (arr[2] - 6) + "日";

    }

    public static String getWeek(int dayOfWeek) {
        String week = "星期";
        switch (dayOfWeek) {
            case 1:
                week += "天";
                break;
            case 2:
                week += "一";
                break;
            case 3:
                week += "二";
                break;
            case 4:
                week += "三";
                break;
            case 5:
                week += "四";
                break;
            case 6:
                week += "五";
                break;
            case 7:
                week += "六";
                break;
        }
        return week;
    }

    /**
     * 如果时间是个位数，就在前面加一个0
     */
    private static String timechange(int time) {
        if (0 <= time && time <= 9) {
            return "0" + time;
        } else {
            return time + "";
        }
    }

    /**
     * 根据时分返回正确的时间格式
     */
    public static String Timeformat(int hour, int minute) {
        return timechange(hour) + ":" + timechange(minute);
    }


    /**
     * 获取未来N天的日期
     *
     * @return 未来N天的string[]
     * @int 未来N天
     */
    public static String[] FutureDays(int day) {
        String[] str = new String[day];
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();// 取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        for (int i = 0; i < day; i++) {
            date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
            str[i] = df.format(date);
            calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
        }
        return str;
    }

    /**
     * 获取当天日期
     *
     * @return 返回例如 yyyy-MM-dd
     */
    public static String toDayDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * 获取当前时间
     *
     * @return 返回例如 20:20
     */
    public static String toDayTime() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }

    /**
     * 获取当前时间
     *
     * @return int[] time = {20,20} 。20:20
     */
    public static int[] toDayTimeIntArray() {
        String time = toDayTime();
        return new int[]{Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1])};
    }
}
