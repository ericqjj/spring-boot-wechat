package com.wechat.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by hztps on 2017/5/12.
 */
public class DateUtils {

    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_HMS_PATTERN = "HH:mm:ss";
    public static final String TIME_HM_PATTERN = "HH:mm";
    public static final String SN_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";
    private static final Locale local;

    public DateUtils() {
    }

    public static String format(Date dateTime, String pattern) {
        return null == dateTime ? null : (pattern != null && !pattern.equals("") ? (new SimpleDateFormat(pattern, local)).format(dateTime) : null);
    }

    public static String formatNow(String pattern) {
        return pattern != null && !pattern.equals("") ? format(new Date(), (String) null) : null;
    }

    public static String formatTime(Date time, String pattern) {
        if (time == null) {
            return null;
        } else {
            if (pattern == null || pattern.equals("")) {
                pattern = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat df = new SimpleDateFormat(pattern, local);
            return df.format(time);
        }
    }

    public static String formatTime(Date time) {
        return formatTime(time, (String) null);
    }

    public static String formatNowTime() {
        return formatTime(new Date(), (String) null);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        } else {
            if (pattern == null || pattern.equals("")) {
                pattern = "yyyy-MM-dd";
            }

            SimpleDateFormat df = new SimpleDateFormat(pattern, local);
            return df.format(date);
        }
    }

    public static String formatDate(Date date) {
        return formatDate(date, (String) null);
    }

    public static String formatNowDate() {
        return formatDate(new Date(), (String) null);
    }

    public static Date parse(String dateTime, String pattern) throws ParseException {
        return null == dateTime ? null : (pattern != null && !pattern.equals("") ? (new SimpleDateFormat(pattern, local)).parse(dateTime) : null);
    }

    public static Date parseTime(String time) throws ParseException {
        return parse(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parseDate(String date) throws ParseException {
        return parse(date, "yyyy-MM-dd");
    }

    public static String getWeek(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        int weekDay = calendar.get(7);
        String day = "";
        switch (weekDay) {
            case 2:
                day = "星期一";
                break;
            case 3:
                day = "星期二";
                break;
            case 4:
                day = "星期三";
                break;
            case 5:
                day = "星期四";
                break;
            case 6:
                day = "星期五";
                break;
            case 7:
                day = "星期六";
                break;
            default:
                day = "星期日";
        }

        return day;
    }

    public static int getWeekNum(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        int weekDay = calendar.get(7);
        boolean day = true;
        byte day1;
        switch (weekDay) {
            case 2:
                day1 = 2;
                break;
            case 3:
                day1 = 3;
                break;
            case 4:
                day1 = 4;
                break;
            case 5:
                day1 = 5;
                break;
            case 6:
                day1 = 6;
                break;
            case 7:
                day1 = 7;
                break;
            default:
                day1 = 1;
        }

        return day1;
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(1);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(2) + 1;
    }

    public static int getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(3);
    }

    public static int getWeekOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(4);
    }

    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static int getDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(6);
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(7);
    }

    public static int getTotalDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.getActualMaximum(5);
    }

    public static int getTotalDaysOfYear(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.getActualMaximum(6);
    }

    public static int getDay(Date date) {
        return getDayOfMonth(date);
    }

    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(11);
    }

    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(12);
    }

    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        return calendar.get(13);
    }

    public static int getRemainderSecondsOfToday() {
        return getRemainderMSecondsOfToday() / 1000;
    }

    public static int getRemainderMSecondsOfToday() {
        Calendar cal = Calendar.getInstance(local);
        cal.set(5, cal.get(5) + 1);
        cal.set(11, 0);
        cal.set(12, 0);
        cal.set(13, 0);
        cal.set(14, 0);
        return Integer.parseInt(String.valueOf(cal.getTime().getTime() - (new Date()).getTime()));
    }

    public static int getCurYear() {
        return getYear(new Date());
    }

    public static int getCurMonth() {
        return getMonth(new Date());
    }

    public static int getCurDay() {
        return getDay(new Date());
    }

    public static int getCurMinute() {
        return getMinute(new Date());
    }

    public static int getCurSecond() {
        return getSecond(new Date());
    }

    public static boolean isAM(Date date) {
        GregorianCalendar ca = new GregorianCalendar(local);
        ca.setTime(date);
        return ca.get(9) == 0;
    }

    public static boolean isAM() {
        return isAM(new Date());
    }

    public static boolean isPM(Date date) {
        GregorianCalendar ca = new GregorianCalendar(local);
        ca.setTime(date);
        return ca.get(9) == 1;
    }

    public static boolean isPM() {
        return isPM(new Date());
    }

    public static boolean isSameAM(Date date) {
        return isAM(date) && isAM(new Date());
    }

    public static boolean isSamePM(Date date) {
        return isPM(date) && isPM(new Date());
    }

    public static boolean isSameAM_PM(Date date) {
        return isSameAM(date) && isSamePM(date);
    }

    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        int week = calendar.get(7);
        return week == 1 || week == 7;
    }

    public static boolean isWeekend() {
        return isWeekend(new Date());
    }

    public static boolean isAfter(Date sendDate) {
        return (new Date()).before(sendDate);
    }

    public static boolean isBefore(Date sendDate) {
        return (new Date()).after(sendDate);
    }

    public static Date addYear(Date date, int num) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        calendar.add(1, num);
        return calendar.getTime();
    }

    public static Date minusYear(Date date, int amount) {
        return addYear(date, -amount);
    }

    public static Date addMonth(Date date, int amount) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        calendar.add(2, amount);
        return calendar.getTime();
    }

    public static Date minusMonth(Date date, int amount) {
        return addMonth(date, -amount);
    }

    public static Date addDay(Date date, int amount) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        calendar.add(6, amount);
        return calendar.getTime();
    }

    public static Date minusDay(Date date, int amount) {
        return addDay(date, -amount);
    }

    public static Date addMinute(Date date, int amount) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        calendar.add(12, amount);
        return calendar.getTime();
    }

    public static Date minusMinute(Date date, int amount) {
        return addMinute(date, -amount);
    }

    public static Date addSecond(Date date, int amount) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        calendar.add(13, amount);
        return calendar.getTime();
    }

    public static Date minusSecond(Date date, int amount) {
        return addSecond(date, -amount);
    }

    public static boolean isAnyDayOfMonth(int day) {
        int curDay = getDayOfMonth(new Date());
        return curDay == day;
    }

    public static boolean isAnyDayOfMonth(Date date, int day) {
        int curDay = getDayOfMonth(date);
        return curDay == day;
    }

    public static boolean isCurMoment(Date date) {
        String curMoment = format(new Date(), "HH:mm:ss");
        String moment = format(date, "HH:mm:ss");
        return curMoment.equals(moment);
    }

    public static long diffMilliseconds(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance(local);
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance(local);
        calendar2.setTime(date2);
        return calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
    }

    public static long diffseconds(Date date1, Date date2) {
        return diffMilliseconds(date1, date2) / 1000L;
    }

    public static long diffMinutes(Date date1, Date date2) {
        return diffMilliseconds(date1, date2) / 60000L;
    }

    public static long diffHours(Date date1, Date date2) {
        return diffMilliseconds(date1, date2) / 3600000L;
    }

    public static int diffDaysOfYear(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date1);
        int day1 = calendar.get(6);
        calendar.setTime(date2);
        int day2 = calendar.get(6);
        return day2 - day1;
    }

    public static int diffDays(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date1);
        int year1 = calendar.get(1);
        int day1 = calendar.get(6);
        calendar.setTime(date2);
        int day2 = calendar.get(6);
        int year2 = calendar.get(1);
        int count = 0;
        boolean flag = false;
        if (year1 > year2) {
            count = year2;
            year2 = year1;
            year1 = count;
            count = 0;
            flag = true;
        }

        for (int i = year1; i < year2; ++i) {
            if (isLeapYear(i)) {
                count += 366;
            } else {
                count += 365;
            }
        }

        if (flag) {
            count = -count;
        }

        return count + day2 - day1;
    }

    public static int diffWeeksOfYear(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date1);
        int week1 = calendar.get(3);
        calendar.setTime(date2);
        int week2 = calendar.get(3);
        return week2 - week1;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static boolean isLeapYear(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        int year = calendar.get(1);
        return isLeapYear(year);
    }

    public static String getPreMonthLastDay() {
        Calendar calendar = Calendar.getInstance(local);
        int day = calendar.get(5);
        calendar.add(5, -day);
        Date date = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd", local);
        return df.format(date);
    }

    public static Date getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(addMonth(date, 1));
        int day = calendar.get(5);
        calendar.setTime(minusDay(calendar.getTime(), day));
        return calendar.getTime();
    }

    public static Date getCurMonthLastDay() {
        return getMonthLastDay(new Date());
    }

    public static boolean isMonthFirstDay(Date date) {
        return getDayOfMonth(date) == 1;
    }

    public static boolean isMonthLastDay(Date date) {
        return getMonthLastDay(date).equals(date);
    }

    public static boolean isCurMonthFirstDay() {
        return isMonthFirstDay(new Date());
    }

    public static boolean isCurMonthLastDay() {
        return isMonthLastDay(new Date());
    }

    public static boolean isAfterDay(Date date) {
        return diffDays(new Date(), date) == 2;
    }

    public static boolean isTomorrow(Date date) {
        return diffDays(new Date(), date) == 1;
    }

    public static boolean isToday(Date date) {
        return diffDays(new Date(), date) == 0;
    }

    public static boolean isYesterday(Date date) {
        return diffDays(new Date(), date) == -1;
    }

    public static boolean isBeforeday(Date date) {
        return diffDays(new Date(), date) == -2;
    }

    public static boolean isCurWeek(Date date) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date);
        int year1 = calendar.get(1);
        int week1 = calendar.get(3);
        calendar.setTime(new Date());
        int year2 = calendar.get(1);
        int week2 = calendar.get(3);
        return year1 == year2 && week1 == week2;
    }

    public static boolean isPreWeek(Date date) {
        long dayNum = (long) diffDays(new Date(), date);
        if (dayNum <= 14L && isSameYear(new Date(), date)) {
            int num = diffWeeksOfYear(new Date(), date);
            return num == -1;
        } else {
            return false;
        }
    }

    public static boolean isWeekEnd(Date date) {
        int num = getWeekNum(date);
        return num == 1 || num == 7;
    }

    public static boolean isSameYear(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date1);
        int year1 = calendar.get(1);
        calendar.setTime(date2);
        int year2 = calendar.get(1);
        return year1 == year2;
    }

    public static boolean isSameMonthOfYear(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date1);
        int year1 = calendar.get(1);
        int month1 = calendar.get(2);
        calendar.setTime(date2);
        int year2 = calendar.get(1);
        int month2 = calendar.get(2);
        return year1 == year2 && month1 == month2;
    }

    public static boolean isSameWeekOfYear(Date date1, Date date2) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(date1);
        int year1 = calendar.get(1);
        int week1 = calendar.get(3);
        calendar.setTime(date2);
        int year2 = calendar.get(1);
        int week2 = calendar.get(3);
        return year1 == year2 && week1 == week2;
    }

    public static boolean isSameDayOfYear(Date date1, Date date2) {
        return diffDays(date1, date2) == 0;
    }

    public static final Date dateAfter(Date origDate, int amount, int timeUnit) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(origDate);
        calendar.add(timeUnit, amount);
        return calendar.getTime();
    }

    public static final Date dateBefore(Date origDate, int amount, int timeUnit) {
        Calendar calendar = Calendar.getInstance(local);
        calendar.setTime(origDate);
        calendar.add(timeUnit, -amount);
        return calendar.getTime();
    }

    public static boolean checkDate(String dateTime, String pattern) {
        try {
            return parse(dateTime, pattern) != null;
        } catch (ParseException var3) {
            return false;
        }
    }

    public static boolean checkDate(String date) {
        return checkDate(date, "yyyy-MM-dd HH:mm:ss") ? true : (checkDate(date, "yyyy年MM月dd日 HH时mm分ss秒") ? true : (checkDate(date, "yyyy/MM/dd HH:mm:ss") ? true : (checkDate(date, "yyyyMMddHHmmss") ? true : (checkDate(date, "yyyy-MM-dd") ? true : (checkDate(date, "yyyy年MM月dd日") ? true : (checkDate(date, "yyyy/MM/dd") ? true : checkDate(date, "yyyyMMdd")))))));
    }

    public static String getNowTimeSN() {
        return formatDate(new Date(), "yyyyMMddHHmmssSSS");
    }

    public static Long getTodayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static Long getTodayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 24);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static long changeStringToLong(String time) {
        long date = 0L;

        try {
            if (time != null && !time.trim().equals("")) {
                SimpleDateFormat e;
                if (time.indexOf("/") > -1) {
                    e = new SimpleDateFormat("yyyy/MM/dd");
                    date = e.parse(time).getTime();
                } else if (time.indexOf("-") > -1) {
                    e = new SimpleDateFormat("yyyy-MM-dd");
                    date = e.parse(time).getTime();
                }
            }
        } catch (Exception var4) {
            date = 0L;
            var4.printStackTrace();
        }

        return date;
    }

    public static void main(String[] args) throws ParseException {
    }

    static {
        local = Locale.CHINA;
    }
}
