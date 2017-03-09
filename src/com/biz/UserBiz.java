package com.biz;

import com.entity.ClazzEntity;
import com.entity.User;

import java.util.List;

/**
 * Created by LinXu on 2017/3/8.
 */
public interface UserBiz {
     boolean login(User user);
     void setDatas(User user);
     void setSignData(User user);
}
