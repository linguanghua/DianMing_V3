package com.dao;

import com.entity.ClazzEntity;

import java.util.List;

/**
 * Created by LinXu on 2017/3/9.
 */
public interface ClassDao {
    List<ClazzEntity> getAllClass();
    boolean addClass(ClazzEntity clazzEntity);
    boolean updateClass(ClazzEntity clazzEntity);
    boolean delClass(Integer cid);
}
