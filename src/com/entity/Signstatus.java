package com.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by LinXu on 2017/3/9.
 */
@Entity
public class Signstatus {
    private int id;
    private String stuId;
    private int classId;
    private String day;
    private int sign;
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
    @Column(name = "stuId")
    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
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
    @Column(name = "day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Basic
    @Column(name = "sign")
    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
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

        Signstatus that = (Signstatus) o;

        if (id != that.id) return false;
        if (classId != that.classId) return false;
        if (sign != that.sign) return false;
        if (lesson != that.lesson) return false;
        if (stuId != null ? !stuId.equals(that.stuId) : that.stuId != null) return false;
        if (day != null ? !day.equals(that.day) : that.day != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stuId != null ? stuId.hashCode() : 0);
        result = 31 * result + classId;
        result = 31 * result + (day != null ? day.hashCode() : 0);
        result = 31 * result + sign;
        result = 31 * result + lesson;
        return result;
    }
}
