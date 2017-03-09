package com.action;

import com.dao.ChangePwdDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by LinXu on 2017/3/9.
 */
@ParentPackage("json-default")
@Results(@Result(name = "chang",type = "json"))
public class ChangePwdAction extends ActionSupport{
    boolean b;

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    String pwd;
    @Resource(name = "changePwdDao")
    private ChangePwdDao changePwdDao;

    public void setChangePwdDao(ChangePwdDao changePwdDao) {
        this.changePwdDao = changePwdDao;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Action(value = "/changPwdAction")
    public String changPwdAction() throws IOException {

        if(pwd!=null&&!pwd.equals("")){
            System.out.println(pwd);
            Map<String, Object> session = ActionContext.getContext().getSession();
            User user = (User) session.get("user");
            b =changePwdDao.changePwd(user,pwd);
        }
        return "chang";
    }
}
