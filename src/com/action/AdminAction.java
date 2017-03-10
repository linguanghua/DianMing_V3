package com.action;

import com.biz.AdminBiz;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import javax.annotation.Resource;

/**
 * Created by LinXu on 2017/3/9.
 */
@ParentPackage(value = "json-default")
@Results({@Result(name = "getStudentInfo",type = "json"),@Result(name = "deleteClass",type = "json")})
public class AdminAction extends ActionSupport {
    String action;
    Integer cid;
    boolean b;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    JSONArray array;

    public JSONArray getArray() {
        return array;
    }

    public void setArray(JSONArray array) {
        this.array = array;
    }

    @Resource(name = "adminBiz")
    private AdminBiz adminBiz;

    public void setAdminBiz(AdminBiz adminBiz) {
        this.adminBiz = adminBiz;
    }
    @Action(value = "/getActionValue")
    public String getActionValue(){
        if(action.equals("getStudentInfo")){//查看学生信息
            array = adminBiz.setAllStuData(cid);
        }else if(action.equals("addClass")){

        }
        return "getStudentInfo";
    }
    @Action(value = "/delClass")
    public String delClasss(){
        if (action.equals("deleteClass")){
            b=adminBiz.delClass(cid);
        }
        return "deleteClass";
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
