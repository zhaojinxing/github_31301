/**
 * 
 */

package com.jx.modules.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 日期工具类
 * 
 * #Date: 2010-9-27
 * 
 * #Title: DateTimeUtil.java
 * 
 * #Company: CreditEase
 * 
 * #Time: 上午09:11:04
 * 
 * #Author: yub
 * 
 * #Email:yb989@126.com
 */
public class DateTimeUtil {

    private final static Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

    private static final String TIME_FORMAT_SHORT = "yyyyMMddHHmmss";

    private static final String TIME_FORMAT_YMD = "yyyy/MM/dd HH:mm:ss";

    public static final String TIME_FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";

    private static final String TIME_FORMAT_ENGLISH = "MM/dd/yyyy HH:mm:ss";

    public static final String TIME_FORMAT_CHINA = "yyyy年MM月dd日 HH时mm分ss秒";

    private static final String TIME_FORMAT_CHINA_S = "yyyy年M月d日 H时m分s秒";

    private static final String TIME_FORMAT_CHINA_N = "M月d日 HH:mm";

    private static final String TIME_FORMAT_SHORT_S = "HH:mm:ss";

    private static final String TIME_FORMAT_SHORT_SS = "HHmmss";

    private static final String TIME_FORMAT_SHORT_SSS = "yyyyMMddHHmmssS";

    private static final String DATE_FORMAT_SHORT = "yyyyMMdd";

    private static final String DATE_FORMAT_DOT = "yyyy.M.d";

    public static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd";

    private static final String DATE_FORMAT_ENGLISH = "MM/dd/yyyy";

    private static final String DATE_FORMAT_CHINA = "yyyy年MM月dd日";

    private static final String DATE_FORMAT_CHINA_YEAR_MONTH = "yyyy年MM月";

    private static final String MONTH_FORMAT = "yyyyMM";

    private static final String YEAR_MONTH_FORMAT = "yyyy-MM";

    private static final String DATE_FORMAT_MINUTE = "yyyyMMddHHmm";

    private static final String MONTH_DAY_FORMAT = "MM-dd";
    
    private static final String DAY_FORMAT = "dd";

    private static final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NORMAL);

    private static final SimpleDateFormat sdfTime = new SimpleDateFormat(TIME_FORMAT_NORMAL);

    private static final SimpleDateFormat sdfTimer = new SimpleDateFormat(TIME_FORMAT_NORMAL);

    private static final String DAY_SHORT = "d";
    
    private static final String MONTH_SHORT = "M";
    
    private static final String YRAR_FORMAT = "yyyy";
    
    /**
     * 改变时间 譬如： changeDate(new Date(),Calendar.DATE, 2) 就是把当前时间加两天
     * 
     * @param originDate 原始时间
     * @param field 改变类型
     * @param distance 长度
     * @return 改变后的时间
     * @since 0.1
     */
    public static Date changeDate(Date originDate, int field, int distance) {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        c.setTime(originDate);
        c.add(field, distance);
        return c.getTime();
    }

    /**
     * 把日期字符串转换为日期类型
     * 
     * @param dateStr 日期字符串
     * @return 日期
     * @since 0.1
     */
  /*  public static Date convertAsDate(String dateStr) {
        if (dateStr == null || "".equals(dateStr)) {
            return null;
        }
        DateFormat fmt = null;
        if (dateStr.matches("\\d{14}")) {
            fmt = new SimpleDateFormat(TIME_FORMAT_SHORT);
        } else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            fmt = new SimpleDateFormat(TIME_FORMAT_NORMAL);
        } else if (dateStr.matches("\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            fmt = new SimpleDateFormat(TIME_FORMAT_ENGLISH);
        } else if (dateStr.matches("\\d{4}年\\d{1,2}月\\d{1,2}日 \\d{1,2}时\\d{1,2}分\\d{1,2}秒")) {
            fmt = new SimpleDateFormat(TIME_FORMAT_CHINA);
        } else if (dateStr.matches("\\d{8}")) {
            fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
        } else if (dateStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
            fmt = new SimpleDateFormat(DATE_FORMAT_NORMAL);
        } else if (dateStr.matches("\\d{1,2}/\\d{1,2}/\\d{4}")) {
            fmt = new SimpleDateFormat(DATE_FORMAT_ENGLISH);
        } else if (dateStr.matches("\\d{4}年\\d{1,2}月\\d{1,2}日")) {
            fmt = new SimpleDateFormat(DATE_FORMAT_CHINA);
        } else if (dateStr.matches("\\d{4}\\d{1,2}\\d{1,2}\\d{1,2}\\d{1,2}")) {
            fmt = new SimpleDateFormat(DATE_FORMAT_MINUTE);
        } else if (dateStr.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            fmt = new SimpleDateFormat(TIME_FORMAT_SHORT_S);
        }
        try {
            return fmt.parse(dateStr);
        }
        catch (ParseException e) {
            logger.warn(e.getMessage(), e);
            throw new IllegalArgumentException("Date or Time String is invalid.");
        }
    }
*/
    /**
     * 
     * Description: 将字符串转换为Date yyyy-mm-dd
     * 
     * @param origin
     * @return
     * @Author yubin
     * @Create Date: 2012-12-21 下午04:12:49
     */
    public static Date convertAsDateString(String origin) {
        try {
            return sdf.parse(origin);
        }
        catch (ParseException e) {
            logger.warn(e.getMessage(), e);
            throw new IllegalArgumentException("Date or Time String is invalid.");
        }
    }

    /**
     * 把 2010-02-04 12:12:34 这样的时间转换为 20100204121234
     * 
     * @param origin 原始时间字符串
     * @return 转换后的字符串
     * @since 0.1
     */
    public static String convertAsShortDateString(String origin) {
        return origin == null ? origin : origin.replaceAll("[-|:|\\s|年|月|日|时|分|秒|/]", "");
    }

    /**
     * 把 20100204121234 这样的时间转换为 2010-02-04 12:12:34
     * 
     * @param origin 原始时间字符串
     * @return 转换后的字符串
     * @since 0.1
     */
    public static String convertAsNormalDateString(String origin) {
        if (origin == null)
            return origin;
        try {
            if (origin.matches("\\d{8}")) {
                SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
                return getDateNormalString(fmt.parse(origin));
            } else if (origin.matches("\\d{14}")) {
                SimpleDateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT);
                return getTimeNormalString(fmt.parse(origin));
            }
        }
        catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        throw new IllegalArgumentException(origin + "is invalid,String format is yyyyMMddHHmmss or yyyyMMdd");
    }

    /**
     * 得到日期字符串,格式为 yyyy年MM月dd日
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateChinaString(Date date) {
        DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_CHINA);
        return fmt.format(date);
    }

    /**
     * 得到日期字符串,格式为 yyyy年MM月dd日
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateChinaString(String strDate) {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT_CHINA);
        String date = "";

        date = format.format(java.sql.Date.valueOf(strDate));

        return date;
    }

    /**
     * 得到日期字符串,格式为 M月d日 HH:mm
     *
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateChinaStringN(String strDate) {
        String date = "";
        DateFormat format = new SimpleDateFormat(TIME_FORMAT_CHINA_N);
        long time = Long.parseLong(strDate);
        Date date1 = new Date(time);
        date = format.format(date1);
        return date;
    }
    /**
     * 得到日期字符串,格式为 M月d日 HH:mm
     *
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateChinaStringM(Date date1) {
        String date = "";
        DateFormat format = new SimpleDateFormat(TIME_FORMAT_CHINA_N);
        date = format.format(date1);
        return date;
    }

    public static String getDateChinaStringYearMonth(Date date) {
        DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_CHINA_YEAR_MONTH);
        return fmt.format(date);
    }

    /**
     * 得到日期字符串,格式为 MM/dd/yyyy
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateEnglishString(Date date) {
        DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_ENGLISH);
        return fmt.format(date);
    }

    /**
     * 得到日期字符串,格式为 yyyy-MM-dd
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateNormalString(Date date) {
        DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_NORMAL);
        return fmt.format(date);
    }

    /**
     * 得到日期字符串,格式为 MM-dd
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getMonthDayDateNormalString(Date date) {
        DateFormat fmt = new SimpleDateFormat(MONTH_DAY_FORMAT);
        return fmt.format(date);
    }
    
    /**
     * 
    	* @title: getDayDateNormalString
    	* @author
    	* @description:得到日期字符串,格式为 dd
    	* @date 2016年7月8日 上午11:46:49
    	* @param date
    	* @return
    	* @throws
     */
    public static String getDayDateNormalString(Date date) {
        DateFormat fmt = new SimpleDateFormat(DAY_FORMAT);
        return fmt.format(date);
    }

    /**
     * 
     * Description: 得到日期字符串，格式为yyyy-MM
     * 
     * @param date
     * @return
     * @Author yubin Create Date: 2012-8-29 上午11:20:31
     */
    public static String getYearMonthString(Date date) {
        DateFormat fmt = new SimpleDateFormat(YEAR_MONTH_FORMAT);
        return fmt.format(date);
    }

    /**
     * 
     * Description: 得到当前日期字符串，格式为yyyy-MM
     * 
     * @return
     * @Author yubin Create Date: 2012-8-29 上午11:28:27
     */
    public static String getNowYearMonthString() {
        return getYearMonthString(new Date());
    }

    /**
     * 得到日期字符串,格式为 yyyyMMdd
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的日期字符串
     * @since 0.1
     */
    public static String getDateShortString(Date date) {
        DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
        return fmt.format(date);
    }

    public static String getDateDotString(Date date) {
        DateFormat fmt = new SimpleDateFormat(DATE_FORMAT_DOT);
        return fmt.format(date);
    }

    /**
     * 得到日期字符串,格式为 yyyy年MM月dd日
     * 
     * @return 返回当前日期的字符串
     */
    public static String getNowDateChinaString() {
        return getDateChinaString(new Date());
    }

    /**
     * 得到日期字符串,格式为 MM/dd/yyyy
     * 
     * @return 返回当前日期的字符串
     */
    public static String getNowDateEnglishString() {
        return getDateEnglishString(new Date());
    }

    /**
     * 得到日期字符串,格式为 yyyy-MM-dd
     * 
     * @return 返回当前日期的字符串
     */
    public static String getNowDateNormalString() {
        return getDateNormalString(new Date());
    }

    /**
     * 得到日期字符串,格式为 yyyy-MM-dd
     * 
     * @param interval 间隔天数
     * @return
     */
    public static String getNowDateNormalString(int interval) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, interval);
        return getDateNormalString(c.getTime());
    }

    /**
     * 获得指定日期的字符串，格式为MM-dd
     * 
     * @param interval
     * @return
     */
    public static String getNowMonthNormalString(int interval) {
        return getNowDateNormalString(interval).substring(5, 10);
    }

    /**
     * 根据输入日期向后累加interval天
     * 
     * @param day
     * @param interval
     * @return
     * @throws ParseException
     */
    public static String getIntervalDaysLater(String day, int interval) {
        if (day == null || "".equals(day)) {
            return "";
        }
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(day));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, interval);
        return getDateNormalString(c.getTime());
    }

    /**
     * 
     * Description: 得到当前日期累加interval天
     * 
     * @param interval
     * @return
     * @Author yubin Create Date: 2012-8-29 下午04:41:43
     */
    public static String getNowDateIntervalDaysLater(int interval) {
        return getIntervalDaysLater(getNowDateNormalString(), interval);
    }

    /**
     * 
     * Description: 月份累加interval
     * 
     * @param day
     * @param interval
     * @return
     * @throws ParseException
     * @Author yubin Create Date: 2012-8-28 上午11:51:41
     */
    public static String getIntervalMonthLater(String day, int interval) {
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(day));
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.MONTH, interval);
        return getDateNormalString(c.getTime());
    }

    /**
     * 得到日期字符串,格式为 MM-dd
     * 
     * @param interval 间隔天数
     * @return
     */
    public static String getNowMonthDayDateNormalString(int interval) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, interval);
        return getMonthDayDateNormalString(c.getTime());
    }

    /**
     * 得到日期字符串,格式为 yyyyMMdd
     * 
     * @return 返回当前日期的字符串
     */
    public static String getNowDateShortString() {
        return getDateShortString(new Date());
    }

    /**
     * 得到时间字符串,格式为 yyyy年MM月dd日 HH时mm分ss秒
     * 
     * @return 返回当前时间的字符串
     */
    public static String getNowTimeChinaString() {
        return getTimeChinaString(new Date());
    }

    /**
     * 
     * Description: 得到时间字符串,格式为 HH:mm:ss
     * 
     * @return
     * @Author yubin Create Date: 2012-8-29 上午11:34:35
     */
    public static String getNowTimeNormalStringS() {
        return getTimeNormalStringS(new Date());
    }

    public static String getNowTimeNormalStringSS() {
        return getTimeNormalStringSS(new Date());
    }

    public static String getNowTimeNormalStringSSS() {
        return getTimeNormalStringSSS(new Date());
    }

    /**
     * 得到时间字符串,格式为 MM/dd/yyyy HH:mm:ss
     * 
     * @return 返回当前时间的字符串
     * 
     */
    public static String getNowTimeEnglishString() {
        return getTimeEnglishString(new Date());
    }

    /**
     * 得到时间字符串,格式为 yyyy-MM-dd HH:mm:ss
     * 
     * @return 返回当前时间的字符串
     */
    public static String getNowTimeNormalString() {
        return getTimeNormalString(new Date());
    }

    /**
     * 得到时间字符串,格式为 yyyyMMddHHmmss
     * 
     * @return 返回当前时间的字符串
     */
    public static String getNowTimeShortString() {
        return getTimeShortString(new Date());
    }

    /**
     * 得到时间字符串,格式为 yyyy年MM月dd日 HH:mm:ss
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的时间字符串
     * @since 0.1
     */
    public static String getTimeChinaString(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_CHINA);
        return fmt.format(date);
    }

    public static String getTimeChinaStringS(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_CHINA_S);
        return fmt.format(date);
    }

    /**
     * 得到时间字符串,格式为 MM/dd/yyyy HH:mm:ss
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的时间字符串
     * @since 0.1
     */
    public static String getTimeEnglishString(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_ENGLISH);
        return fmt.format(date);
    }

    /**
     * 得到时间字符串,格式为 yyyy-MM-dd HH:mm:ss
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的时间字符串
     * @since 0.1
     */
    public static String getTimeNormalString(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_NORMAL);
        return fmt.format(date);
    }

    /**
     * 得到时间字符串,格式为 yyyy/MM/dd HH:mm:ss
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的时间字符串
     * @since 0.1
     */
    public static String getTimeNormalSprit(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_YMD);
        return fmt.format(date);
    }
    
    /**
     * 得到时间字符串,格式为 指定格式字符串
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的时间字符串
     * @since 0.1
     */
    public static String getTimeNormalStringByFormat(Date date,String formatString) {
        DateFormat fmt = new SimpleDateFormat(formatString);
        return fmt.format(date);
    }

    /**
     * 
     * Description: 得到时间字符串，格式为HH:mm:ss
     * 
     * @param date
     * @return
     * @Author yubin Create Date: 2012-8-29 上午11:21:20
     */
    public static String getTimeNormalStringS(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT_S);
        return fmt.format(date);
    }

    public static String getTimeNormalStringSS(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT_SS);
        return fmt.format(date);
    }

    public static String getTimeNormalStringSSS(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT_SSS);
        return fmt.format(date);
    }

    /**
     * 得到时间字符串,格式为 yyyyMMddHHmmss
     * 
     * @param date 待格式化日期
     * @return 返回格式化后的时间字符串
     * @since 0.1
     */
    public static String getTimeShortString(Date date) {
        DateFormat fmt = new SimpleDateFormat(TIME_FORMAT_SHORT);
        return fmt.format(date);
    }

    /**
     * 得到时间字符串,格式为 yyyyMM
     * 
     * @param date
     * @return
     * @since 0.1
     */
    public static String getMonthString(Date date) {
        DateFormat fmt = new SimpleDateFormat(MONTH_FORMAT);
        return fmt.format(date);
    }

    /**
     * 得到时间字符串,格式为 M月d日
     * 
     * @param day 相隔几天
     * @return
     * @since 0.1
     */
    public static String getMonthDay(int day) {
        DateFormat fmt = new SimpleDateFormat("M月d日");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, day);
        return fmt.format(c.getTime());
    }

    /**
     * 获得日期集合
     * 
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @return
     * @throws ParseException
     */
    public static List<String> getDateList(String beginDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NORMAL);
        List<String> list = new ArrayList<String>();
        Calendar c1 = Calendar.getInstance(Locale.CHINA);
        c1.setTime(sdf.parse(beginDate));
        Calendar c2 = Calendar.getInstance(Locale.CHINA);
        c2.setTime(sdf.parse(endDate));
        long l1 = c1.getTimeInMillis();
        long l2 = c2.getTimeInMillis();
        int interval = (int) ((l2 - l1) / (1000 * 60 * 60 * 24));
        for (int i = 0; i <= interval; i++) {
            Calendar c = Calendar.getInstance();
            c.setTime(c1.getTime());
            c.add(Calendar.DATE, i);
            list.add(sdf.format(c.getTime()));
        }
        return list;
    }

    /**
     * 获得输入日期所在周的第一天（周一为第一天）
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfWeek(String day) throws ParseException {
        Calendar c1 = Calendar.getInstance(Locale.CHINA);
        c1.setTime(sdf.parse(day));
        c1.setFirstDayOfWeek(Calendar.MONDAY);
        c1.set(Calendar.DAY_OF_WEEK, c1.getFirstDayOfWeek());
        return sdf.format(c1.getTime());
    }

    /**
     * 获得输入日期所在周的最后一天（周日为最后一天）
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static String getLastDayOfWeek(String day) throws ParseException {
        Calendar c1 = Calendar.getInstance(Locale.CHINA);
        c1.setTime(sdf.parse(day));
        c1.setFirstDayOfWeek(Calendar.MONDAY);
        c1.set(Calendar.DAY_OF_WEEK, c1.getFirstDayOfWeek() + 6);
        return sdf.format(c1.getTime());
    }

    /**
     * 计算输入日期所在月的最后一天
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static String getLastDayOfMonth(String day) throws ParseException {
        Calendar c1 = Calendar.getInstance(Locale.CHINA);
        c1.setTime(sdf.parse(day));
        c1.set(Calendar.DAY_OF_MONTH, 1);
        c1.add(Calendar.MONTH, 1);
        c1.add(Calendar.DAY_OF_MONTH, -1);
        return sdf.format(c1.getTime());
    }

    /**
     * 
     * Description: 计算当前日期上一个月的最后一天
     * 
     * @return yyyy年MM月dd日
     * @throws Exception
     * @Author lijie
     * @Create Date: 2013-9-28 下午01:47:24
     */
//    public static String getLastDayOfMonthChina() throws Exception {
//        return getDateChinaString(convertAsDate(getLastDayOfMonth(getLastDate(DATE_FORMAT_NORMAL))));
//    }

    /**
     * 计算输入日期所在月的第一天
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfMonth(String day) throws ParseException {
        Calendar c1 = Calendar.getInstance(Locale.CHINA);
        c1.setTime(sdf.parse(day));
        c1.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(c1.getTime());
    }

    /**
     * 
     * Description: 计算当前日期上一个月的第一天
     * 
     * @return yyyy年MM月dd日
     * @throws Exception
     * @Author lijie
     * @Create Date: 2013-9-28 下午01:39:21
     */
//    public static String getFirstDayOfMonthChina() throws Exception {
//        return getDateChinaString(convertAsDate(getFirstDayOfMonth(getLastDate(DATE_FORMAT_NORMAL))));
//    }

    /**
     * 是否是当月的第一天
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static boolean isFirstDayOfMonth(String day) throws ParseException {
        return day.equals(getFirstDayOfMonth(day)) ? true : false;
    }

    /**
     * 是否是当月的最后一天
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static boolean isLastDayOfMonth(String day) throws ParseException {
        return day.equals(getLastDayOfMonth(day)) ? true : false;
    }

    /**
     * 是否是当前周的第一天
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static boolean isFirstDayOfWeek(String day) throws ParseException {
        return day.equals(getFirstDayOfWeek(day)) ? true : false;
    }

    /**
     * 是否是当前周的最后一天
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static boolean isLastDayOfWeek(String day) throws ParseException {
        return day.equals(getLastDayOfWeek(day)) ? true : false;
    }

    /**
     * 计算输入日期所在周是否跨月
     * 
     * @param day
     * @return
     * @throws ParseException
     */
    public static boolean isDayBetweenMonthAndWeek(String day) throws ParseException {
        String firstDayOfMonth = getFirstDayOfMonth(day);
        String firstDayOfWeek = getFirstDayOfWeek(day);
        Pattern p = Pattern.compile("\\d{4}-\\d{2}-01");
        Matcher m = p.matcher(day);
        if (firstDayOfWeek.compareTo(firstDayOfMonth) < 0 && !m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 输入的日期是否为时间格式
     * 
     * @param input
     * @return
     */
    public static boolean isInputDate(String input) {
        return input.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
    }

    public static boolean isInputDateNormalString(String input) {
        return input.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    /**
     * 将日期字符串格式化为yyyy-MM-dd
     * 
     * @param input
     * @return
     */
    public static String formatDateString(String input) throws IllegalArgumentException {
        String month = "";
        String day = "";
        try {
            if (!isInputDate(input)) {
                throw new IllegalArgumentException("日期格式不合法");
            }
            if (isInputDateNormalString(input)) {
                return input;
            }
            month = input.substring(input.indexOf("-") + 1, input.lastIndexOf("-"));
            if (month.length() == 1 && month.indexOf("0") != 0)
                month = "0" + month;
            day = input.substring(input.lastIndexOf("-") + 1, input.length());
            if (day.length() == 1 && day.indexOf("0") != 0)
                day = "0" + day;
        }
        catch (Exception e) {
            e.printStackTrace();
            return input;
        }
        return input.substring(0, 4) + "-" + month + "-" + day;
    }

    /**
     * 组装当前时间的开始时间戳
     * 
     * */
    public static String getDateNowStr() {

        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        // 当前月
        int month = (c1.get(Calendar.MONTH)) + 1;
        // 当前月的第几天：即当前日
        int day_of_month = c1.get(Calendar.DAY_OF_MONTH);
        String time = year + "-" + month + "-" + day_of_month + " 00:00:00";
        return time;
    }

    /**
     * 组装当前时间的结束时间戳
     * 
     * */
    public static String getDateNowStrend() {

        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        // 当前月
        int month = (c1.get(Calendar.MONTH)) + 1;
        // 当前月的第几天：即当前日
        int day_of_month = c1.get(Calendar.DAY_OF_MONTH);
        String time = year + "-" + month + "-" + day_of_month + " 23:59:59";
        return time;
    }

    /**
     * 获取上月的年月日
     * 
     * @param toFormat 日期格式
     * @return
     */
    public static String getLastDate(String toFormat) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat(toFormat);
        String time = format.format(c.getTime());
        return time;
    }

    /**
     * 获取本月的年月日
     * 
     * @param toFormat 日期格式
     * @return
     */
    public static String getDate(String toFormat) {
        SimpleDateFormat format = new SimpleDateFormat(toFormat);
        String time = format.format(new Date());
        return time;
    }

    /**
     * 获取上月的年
     * 
     * @param toFormat 日期格式
     * @return
     */
    public static String getLastYearMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat(YEAR_MONTH_FORMAT);
        String time = format.format(c.getTime());
        return time;
    }

    /**
     * 获取本月的年月
     * 
     * @param toFormat 日期格式
     * @return
     */
    public static String getYearMonth() {
        SimpleDateFormat format = new SimpleDateFormat(YEAR_MONTH_FORMAT);
        String time = format.format(new Date());
        return time;
    }

    /**
     * 获取上月的年
     * 
     * @param toFormat 日期格式
     * @return
     */
    public static String getLastYearMonth(String toFormat) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat(toFormat);
        String time = format.format(c.getTime());
        return time;
    }

    /**
     * 取得当月天数
     * */
    public static int getThisMonthDays() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 得到指定月的天数
     * */
    public static int getLastMonthDays(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取上月天数
     * 
     * @return
     */
    public static int getLastMonthDays() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        int maxDate = cal.get(Calendar.DAY_OF_MONTH);
        return maxDate;
    }

    public static String getStrDatetosimp(String date) {
        SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
        try {
            return getDateShortString(fmt.parse(date));
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定时间前几天
     * */
    public static Date getDateBeforeday(Date dd, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.DATE, -day);    // 得到前一天
        Date date = calendar.getTime();

        return date;
    }

    /**
     * 指定时间前几天
     * */
    public static Date getDateAfterday(Date dd, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.DATE, day);    // 得到前一天
        Date date = calendar.getTime();

        return date;
    }

    /**
     * 指定时间几个月后
     * */
    public static Date getDateAfterMonth(Date dd, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.MONTH, month);
        Date date = calendar.getTime();

        return date;
    }

    /**
     * 指定时间几个年后
     * */
    public static Date getDateAfterYear(Date dd, int year) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.YEAR, year);
        Date date = calendar.getTime();

        return date;
    }

    /**
     * 指定时间前几天
     * */
    public static String getStrDateBeforeday(Date dd, int day) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.DATE, -day);    // 得到前一天
        Date date = calendar.getTime();
        return sdf.format(date);
    }

    /**
     * 获取某一天的某几个月前的某一天
     * */
    public static Date getPreviousMonthOfDay(Date dd, int month) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dd);
        calendar.add(Calendar.MONTH, -month);
        Date date = calendar.getTime();

        return date;
    }

    /**
     * 
     * Description: 得到当前Date类型日期,格式为 yyyy-MM-dd
     * 
     * @return
     * @throws ParseException
     * @Author ouyangjin
     * @Create Date: 2013-10-9 下午03:21:07
     */
    public static Date getCurrentTime() throws ParseException {
        return sdf.parse(getNowDateNormalString());
    }

    /**
     * 
     * @Title: getStrToDate
     * @Description: String转为Date
     * @param date
     * @return
     * @throws Exception Date
     * @throws
     * 
     * @Author dyp
     * @Create Date: 2013-11-22 下午04:05:39
     */
    public static Date getStrToDate(String date, String fomtter) throws Exception {
        DateFormat df = new SimpleDateFormat(fomtter);
        return df.parse(date);
    }

    /**
     * 
     * @param date
     * @return yyyy-MM-dd HH:ss:mm
     * @throws Exception
     */
    public static Date getStrDate(String date) throws Exception {
        return sdfTimer.parse(date);
    }

    /**
     * 
     * @Title: between
     * @Description: 判断日期是否在指定区间内，如09:55:00是否在08:40:30到10:10:00之间
     * @param curentTime 需要判断的日期
     * @param startTime 区间开始日期
     * @param endTime 区间结束日期
     * @return boolean
     * @throws
     * 
     * @Author dyp
     * @Create Date: 2013-12-4 下午06:16:24
     */
    public static boolean betweenTime(String curentTime, String startTime, String endTime) {
        if (startTime.compareTo(endTime) > 0) {
            // 如果开始时间大于结束时间，结束时间+24
            endTime = String.format("%d%s", Integer.valueOf(endTime.substring(0, 2)) + 24, endTime.substring(2));
        }
        return (curentTime.compareTo(startTime) >= 0 && curentTime.compareTo(endTime) <= 0);
    }

    /**
     * @Description: 计算给定时间到现在的间隔天数 yyyy-MM-dd
     * @param string
     * @return
     * @throws Exception
     */
    public static int getDayLength(String date) throws Exception {
        Date fromDate = getStrToDate(date, TIME_FORMAT_NORMAL);  // 开始日期
        Date toDate = getStrToDate(
                new StringBuilder(getTimeNormalString(new Date()).substring(0, 10)).append(" 00:00:00").toString(),
                TIME_FORMAT_NORMAL); // 结束日期
        long from = fromDate.getTime();
        long to = toDate.getTime();
        int day = (int) ((to - from) / (24 * 60 * 60 * 1000));
        return day;
    }

    /**
     * @Description: 转换为格式 yyyy-MM-dd HH:mm:ss
     * @param string
     * @return
     * @throws Exception
     */
    public static Date covertDateFromStr(String date) throws Exception {
        return sdfTime.parse(date);
    }

    public static String nextMonthOfNow() {
        Calendar calendar = Calendar.getInstance();
        // 月份+1
        calendar.add(Calendar.MONTH, 1);
        // 定义输出格式
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT_CHINA);
        // 得到格式化字符串
        String nextMonth = formatter.format(calendar.getTime());
        return nextMonth;
    }

    public static String longToDate(String time) {
        String date = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_NORMAL);
            date = sdf.format(Long.parseLong(time));
        }
        catch (Exception e) {

        }
        return date;
    }

    /**
     * 
     * @title: strLongTimeToDate
     * @author
     * @description:字符串时间戳转换为date
     * @date 2016年4月26日 下午2:13:25
     * @param time 1463846400000
     * @return
     * @throws
     */
    public static Date strLongTimeToDate(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT_NORMAL);
            String date = sdf.format(Long.parseLong(time));
            return sdf.parse(date);
        }
        catch (Exception e) {

        }
        return null;
    }
    
    
    /**
	 * 计算生日
	 * 
	 * @param birthday
	 * @param endDate
	 * @return
	 * 
	 * add by zxc 2014.3.12
	 */
	public static int getAge(Date birthday, Date endDate) {
		return calInterval(birthday, endDate, "Y");
	}

	/**
	 * 通过起始日期和终止日期计算以时间间隔单位为计量标准的时间间隔，舍弃法 author: HST
	 * 起始日期，(String,格式："YYYY-MM-DD")
	 * 
	 * @param cstartDate
	 *            String 终止日期，(String,格式："YYYY-MM-DD")
	 * @param cendDate
	 *            String 时间间隔单位，可用值("Y"--年 "M"--月 "D"--日)
	 * @param unit
	 *            String 时间间隔,整形变量int
	 * @return int
	 * 
	 * add by zxc 2014.3.12
	 */
	public static int calInterval(Date startDate, Date endDate, String unit) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		int interval = 0;
		GregorianCalendar sCalendar = new GregorianCalendar();
		sCalendar.setTime(startDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		int sMonths = sCalendar.get(Calendar.MONTH);
		int sDays = sCalendar.get(Calendar.DAY_OF_MONTH);

		GregorianCalendar eCalendar = new GregorianCalendar();
		eCalendar.setTime(endDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_MONTH);

		if (unit != null && unit.trim().equals("Y")) {
			interval = eYears - sYears;
			if (eMonths < sMonths) {
				interval--;
			} else {
				if (eMonths == sMonths && eDays < sDays) {
					interval--;
					if (eMonths == 1) { // 如果同是2月，校验润年问题
						if ((sYears % 4) == 0 && (eYears % 4) != 0) { // 如果起始年是润年，终止年不是润年
							if (eDays == 28) { // 如果终止年不是润年，且2月的最后一天28日，那么补一
								interval++;
							}
						}
					}
				}
			}
		}
		if (unit != null && unit.trim().equals("M")) {
			interval = eYears - sYears;
			interval *= 12;
			interval += eMonths - sMonths;

			if (eDays < sDays) {
				interval--;
				int maxDate = eCalendar.getActualMaximum(Calendar.DATE);
				if (eDays == maxDate) {
					interval++;
				}
			}
		}
		if (unit != null && unit.trim().equals("D")) {
			sCalendar.set(sYears, sMonths, sDays);
			eCalendar.set(eYears, eMonths, eDays);
			long lInterval = (eCalendar.getTime().getTime() - sCalendar
					.getTime().getTime()) / 86400000;
			interval = (int) lInterval;
		}
		return interval;
	}

     public static long getTwoDateMinute(Date endDate,Date startDate){
    	 long  between=(endDate.getTime()-startDate.getTime())/1000;//除以1000是为了转换成秒
    	 return between%3600/60;
     }
	
	 public static long getTwoDateSecond(Date endDate,Date startDate){
		 return (endDate.getTime()-startDate.getTime())/1000;//除以1000是为了转换成秒
     }
	
	 public static String getDayDateShortString(Date date) {
	        DateFormat fmt = new SimpleDateFormat(DAY_SHORT);
	        return fmt.format(date);
	 }
	
	 public static String getMonthDateShortString(Date date) {
	        DateFormat fmt = new SimpleDateFormat(MONTH_SHORT);
	        return fmt.format(date);
     }
	 
	 public static String getYearDateNormalString(Date date) {
	        DateFormat fmt = new SimpleDateFormat(YRAR_FORMAT);
	        return fmt.format(date);
     }
	
    public static String longToDate1(String time) {
        String date = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NORMAL);
            date = sdf.format(Long.parseLong(time));
        }
        catch (Exception e) {

        }
        return date;
    }
    /**

     *@description time2 是大的时间

     *@param  [time1, time2]

     *@return java.lang.String

     */
    public static String timeSubtraction(String time1, String time2) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
        long newTime1 = simpleDateFormat.parse(time2).getTime();
        long newTime2 = simpleDateFormat.parse(time1).getTime();
        Long result = newTime1 - newTime2;    //获取两时间相差的毫秒数
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long hour = result % nd / nh;     //获取相差的小时数
        long min = result % nd % nh / nm;  //获取相差的分钟数
        long day = result / nd;

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");//初始化Formatter的转换格式。
        long hMiles = hour * 3600000;  //小时数转换成毫秒
        long mMiles = min * 60000;    //分钟数转换成毫秒
        long resulMiles = (hMiles + mMiles);

        //下面这段很重要 ,计算之后设置时区,不然会差几小时
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String resultFormat = formatter.format(resulMiles);
        //我这段是在一天内计算的 如果大于一天 就把下面的 day*24加到小时上就可以了
        return resultFormat + "," + day;
    }

    /**
     * @param [time1, time2]
     * @return java.lang.String
     * @description time2 是大的时间
     */
    public static String timeSubtraction(Date time1, Date time2) throws ParseException {

        long newTime1 = time2.getTime();
        long newTime2 = time1.getTime();
        Long result = newTime1 - newTime2;    //获取两时间相差的毫秒数
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        long hour = result % nd / nh;     //获取相差的小时数
        long min = result % nd % nh / nm;  //获取相差的分钟数
        long sencond = result % nd % nh %nm/ ns;  //获取相差的分钟数
        long day = result / nd;
        long baseHours = result/nh;//获取相差时间小时数

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//初始化Formatter的转换格式。
        long hMiles = hour * 3600000;  //小时数转换成毫秒
        long mMiles = min * 60000;    //分钟数转换成毫秒
        long sMiles = sencond * ns;    //秒数转换成毫秒
        long resulMiles = (hMiles + mMiles+sMiles);

        //下面这段很重要 ,计算之后设置时区,不然会差几小时
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String resultFormat = formatter.format(resulMiles);
        String resultStr = resultFormat.replace(resultFormat.substring(0, 2), String.valueOf(day * 24 + Long.parseLong(resultFormat.substring(0, 2))));
        //我这段是在一天内计算的 如果大于一天 就把下面的 day*24加到小时上就可以了
        return resultStr;
    }

    public static void main(String[] args) throws Exception {
        Date strDate = getStrDate("2019-03-09 17:57:38");
        String s = timeSubtraction(new Date(), strDate);
        logger.info(s);
    }
}
