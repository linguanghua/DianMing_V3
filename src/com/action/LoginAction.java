package com.action;

import com.biz.AdminBiz;
import com.biz.UserBiz;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by LinXu on 2017/3/8.
 */
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven {
    @Resource(name = "userBiz")
    private UserBiz userBiz;

    public void setUserBiz(UserBiz userBiz) {
        this.userBiz = userBiz;
    }

    @Resource(name = "adminBiz")
    private AdminBiz adminBiz;

    public AdminBiz getAdminBiz() {
        return adminBiz;
    }

    private User user = new User();

    @Action(value = "/login", results = {@Result(name = "success", location = "/success.jsp"),
            @Result(name = "error", location = "/error.jsp"), @Result(name = "admin", location = "/admin.jsp")})
    public String login() {
        if (user.getUsername() == null) {
            System.out.println(123);
            Map<String, Object> session = ActionContext.getContext().getSession();
            user = (User) session.get("user");
        }

        if (user != null && user.getUsername() != null && userBiz.login(user)) {
            Map<String, Object> session = ActionContext.getContext().getSession();
            user = (User) session.get("user");
            if (user.getUserType() == 10) {
                adminBiz.setAllClass();
                return "admin";
            } else {
                userBiz.setDatas(user);
                userBiz.setSignData(user);
                return SUCCESS;
            }
        } else {
            return ERROR;
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
