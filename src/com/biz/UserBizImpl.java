package com.biz;

import com.dao.LoginDao;
import com.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LinXu on 2017/3/8.
 */
@Service("userBiz")
public class UserBizImpl implements UserBiz {
    @Resource(name = "loginDao")
    private LoginDao loginDao;

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public String login(User user) {
        return loginDao.login(user);
    }
}
