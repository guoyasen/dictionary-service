package com.iquantex.common.cds.web.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/** @Author wangpb @Date 2020/11/3 @Description */
@Slf4j
public class DateUtil {

  public static final String PATTERN_A = "yyyy-MM-dd";

  public static final String PATTERN_B = "yyMMdd";

  public static final String PATTERN_C = "yyyyMMdd";

  public static final String PATTERN_D = "yyyyMMddhhmmss";

  public static final String PATTERN_E = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

  public static String formatFromTimestamp(String pattern, Long timestamp) {
    return formatFromTimestamp(DateTimeFormatter.ofPattern(pattern), timestamp);
  }

  public static String formatFromTimestamp(String pattern, LocalDateTime localDateTime) {
    long l = localDateTimeToLong(localDateTime);
    return formatFromTimestamp(DateTimeFormatter.ofPattern(pattern), l);
  }

  /**
   * 将时间格式化为字符串时间戳
   *
   * @param formatter
   * @param timestamp
   * @return
   */
  public static String formatFromTimestamp(DateTimeFormatter formatter, Long timestamp) {
    try {
      LocalDateTime dateTime =
          LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
      return dateTime.format(formatter);
    } catch (Exception e) {
      log.error(
          "formatFromTimestamp 解析错误: formatter<{}> timestamp<{}>", formatter.toString(), timestamp);
    }
    return null;
  }

  /**
   * 将字符串转化为时间格式时间戳
   *
   * @param pattern
   * @param stringTime
   * @return
   */
  public static Long localDateFormatToTimestamp(String pattern, String stringTime) {
    return localDateFormatToTimestamp(DateTimeFormatter.ofPattern(pattern), stringTime);
  }

  /**
   * 将字符串转化为时间格式时间戳
   *
   * @param formatter
   * @param stringTime
   * @return
   */
  public static Long localDateFormatToTimestamp(DateTimeFormatter formatter, String stringTime) {
    try {
      return localDateTimeToLong(LocalDate.parse(stringTime, formatter).atStartOfDay());
    } catch (Exception e) {
      log.error(
          "localDateFormatToTimestamp 解析错误: formatter<{}> timestamp<{}>",
          formatter.toString(),
              stringTime);
    }
    return null;
  }

  /**
   * 字符串转Date
   *
   * @param strDate
   * @param pattern
   * @return
   */
  public static Date getDate(String strDate, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    try {
      return sdf.parse(strDate);
    } catch (Exception ex) {
      log.error("日期操作错误", ex);
    }
    return null;
  }

  /**
   * 获取一个日期的零点
   *
   * @param date
   * @return
   */
  public static Date getDateDawn(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_A);
    try {
      return sdf.parse(sdf.format(date));
    } catch (Exception ex) {
      log.error("日期操作错误", ex);
    }
    return date;
  }

  /**
   * @param date
   * @return
   */
  public static String getStrDate(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    try {
      return sdf.format(date);
    } catch (Exception ex) {
      log.error("日期操作错误", ex);
    }
    return null;
  }

  /**
   * 获取下days天
   *
   * @param date
   * @return
   */
  /**
   * 获取beginDate后的days的日期
   *
   * @param beginDate
   * @param days
   * @return
   */
  public static Date getNextDate(Date beginDate, int days) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(beginDate);
    calendar.add(Calendar.DAY_OF_YEAR, days);
    return calendar.getTime();
  }

  /**
   * 获取日期，无具体时间
   *
   * @param timestamp
   * @return
   */
  public static long getLocalDateTimestamp(long timestamp) {
    LocalDateTime dateTime =
        LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
            .toLocalDate()
            .atStartOfDay();
    return localDateTimeToLong(dateTime);
  }

  /**
   * LocalDateTime转化为long
   *
   * @param localDateTime
   * @return
   */
  public static long localDateTimeToLong(LocalDateTime localDateTime) {
    return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
  }

  /**
   * 获取LocalDateTime类型日期
   *
   * @param date
   * @return
   */
  public static LocalDateTime getLocalDateTime(Date date) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }
}
