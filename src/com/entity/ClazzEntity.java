package com.entity;

import javax.persistence.*;

/**
 * Created by LinXu on 2017/3/8.
 */
@Entity
@Table(name = "class", schema = "", catalog = "dianming")
public class ClazzEntity {
    private int id;
    private int classId;
    private String classNum;
    private String className;
    private int studentNum;
    private int week;
    private String classRoom;
    private String classTime;
    private int lesson;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "classId")
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "classNum")
    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    @Basic
    @Column(name = "className")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "studentNum")
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Basic
    @Column(name = "week")
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "classRoom")
    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    @Basic
    @Column(name = "classTime")
    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    @Basic
    @Column(name = "lesson")
    public int getLesson() {
        return lesson;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClazzEntity that = (ClazzEntity) o;

        if (id != that.id) return false;
        if (classId != that.classId) return false;
        if (studentNum != that.studentNum) return false;
        if (week != that.week) return false;
        if (lesson != that.lesson) return false;
        if (classNum != null ? !classNum.equals(that.classNum) : that.classNum != null) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (classRoom != null ? !classRoom.equals(that.classRoom) : that.classRoom != null) return false;
        if (classTime != null ? !classTime.equals(that.classTime) : that.classTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + classId;
        result = 31 * result + (classNum != null ? classNum.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + studentNum;
        result = 31 * result + week;
        result = 31 * result + (classRoom != null ? classRoom.hashCode() : 0);
        result = 31 * result + (classTime != null ? classTime.hashCode() : 0);
        result = 31 * result + lesson;
        return result;
    }
}
