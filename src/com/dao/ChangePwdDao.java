package com.dao;

import com.entity.User;

/**
 * Created by LinXu on 2017/3/9.
 */
public interface ChangePwdDao {
    boolean changePwd(User user,String pwd);
}
