package com.action;

import com.biz.UserBiz;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by LinXu on 2017/3/8.
 */
@Controller @Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven{
    @Resource(name = "userBiz")
    private UserBiz userBiz;

    private User user = new User();

    @Action(value = "/login",results = {@Result(name = "success",location = "/success.jsp"),
        @Result(name = "error",location = "/error.jsp")})
    public String login(){

        if(userBiz.login(user)){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
