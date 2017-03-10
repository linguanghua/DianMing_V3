package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by LinXu on 2017/3/9.
 */
@Controller @Scope("prototype")
public class LogoutAction extends ActionSupport {
    String action;
    @Action(value = "/logout",results = {@Result(name = "logout",location = "/index.jsp"),
            @Result(name = "error",location = "/error.jsp")})
    public String logout(){
        if(action.equals("logout")){
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.clear();
            return "logout";
        }else{
            return "error";
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
