package com.wdq;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2021/06/09
 */
public class TestTime {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 8, 27);
        int year = date.getYear();//2019----获取年份
        Month month = date.getMonth();//AUGUST----获取月份
        int day = date.getDayOfMonth();//27----获取天数
        DayOfWeek dow = date.getDayOfWeek();//TUESDAY----获取星期几
        int len = date.lengthOfMonth();//31----获取当月天数
        boolean leap = date.isLeapYear();//false----获取是否闰年


        LocalTime time = LocalTime.of(23, 45, 20);
        int hour = time.getHour();//23----获取小时
        int minute = time.getMinute();//45----获取分钟
        int second = time.getSecond();//20----获取秒数



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date1 = LocalDate.of(1995, 4, 30);//1995-04-30
        String formattedDate = date1.format(formatter);//1995-04-30
        String formattedDate2 = date1.format(formatter2);//
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);//30/04/1995

        System.out.println("date2 = " + date2);
    }
}
