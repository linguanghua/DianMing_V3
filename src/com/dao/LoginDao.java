package com.dao;

import com.entity.ClazzEntity;
import com.entity.User;

import java.util.List;

/**
 * Created by LinXu on 2017/3/8.
 */
public interface LoginDao {
      List<User> login(User user);
      List<ClazzEntity> getClasses(User user);
}
