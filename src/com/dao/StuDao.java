package com.dao;

import com.entity.ClazzEntity;
import com.entity.User;

import java.util.List;

/**
 * Created by LinXu on 2017/3/9.
 */
public interface StuDao {
    List<User> getStudentInfo(Integer classId);
    List<ClazzEntity> getAllClass();
}
