package com.entity;

/**
 * Created by LinXu on 2017/3/9.
 */
public class TeaSignInfo {
    private String stuId;
    private String stuName;
    private String day;
    private int sign;
    private int lesson;
    private int week;
    private String className;
    private int classId;

    public TeaSignInfo(){}

    public TeaSignInfo(String stuId, String stuName, String day, int sign, int lesson, int week, String className, int classId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.day = day;
        this.sign = sign;
        this.lesson = lesson;
        this.week = week;
        this.className = className;
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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

    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
