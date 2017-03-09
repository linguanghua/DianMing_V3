package com.dao;

import com.entity.StuSignInfo;
import com.entity.User;

import java.util.List;

/**
 * Created by LinXu on 2017/3/9.
 */
public interface SignInfoDao {
    List<StuSignInfo> getStuSignData(User user);
}
