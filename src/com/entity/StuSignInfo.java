package com.entity;

import java.io.Serializable;

/**
 * Created by LinXu on 2017/3/9.
 */
public class StuSignInfo implements Serializable {

    private String day;//日期
    private int sign;//签到状态
    private String className;//课程名称
    private int week;//星期
    private int lesson; //哪节课
    public StuSignInfo(){}

    public StuSignInfo(String day, int sign, String className, int week, int lesson) {
        this.day = day;
        this.sign = sign;
        this.className = className;
        this.week = week;
        this.lesson = lesson;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }
}
