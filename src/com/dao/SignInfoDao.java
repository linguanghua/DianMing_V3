package com.dao;

import com.entity.StuSignInfo;
import com.entity.TeaSignInfo;
import com.entity.User;

import java.util.List;

/**
 * Created by LinXu on 2017/3/9.
 */
public interface SignInfoDao {
    List<StuSignInfo> getStuSignData(User user);
    List<TeaSignInfo> getTeaSignInfo(Integer classId);
    List<Integer> getTClassId(User user);
}
