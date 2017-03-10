package com.action;

import com.biz.AdminBiz;
import com.entity.ClazzEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;

/**
 * Created by LinXu on 2017/3/10.
 */
@ParentPackage(value = "json-default")
@Results(@Result(name = "add",type = "json"))
public class AddClassAction extends ActionSupport {
   private boolean b;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Resource(name = "adminBiz")
    private AdminBiz adminBiz;

    public void setAdminBiz(AdminBiz adminBiz) {
        this.adminBiz = adminBiz;
    }

    @Action(value = "/addClass")
    public String addClass(){
        System.out.println(action);
        if(action.equals("addClass")){
            ClazzEntity clazzEntity = new ClazzEntity();
            clazzEntity.setClassId(classId);
            clazzEntity.setClassName(className);
            clazzEntity.setClassRoom(classRoom);
            clazzEntity.setWeek(week);
            clazzEntity.setLesson(lesson);
            clazzEntity.setClassNum(null);
            clazzEntity.setClassTime(null);
            clazzEntity.setStudentNum(0);
            if(activeType==0){//添加，修改
                b = adminBiz.addClass(clazzEntity);
            }else if(activeType==1){
                b = adminBiz.updateClass(clazzEntity);
            }
        }
        return "add";
    }



    private String action;
    private Integer classId;
    private String className;
    private String classRoom;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
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

    public int getActiveType() {
        return activeType;
    }

    public void setActiveType(int activeType) {
        this.activeType = activeType;
    }

    private int week;
    private int lesson;
    private int activeType;
}
