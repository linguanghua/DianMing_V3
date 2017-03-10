package com.biz;

import com.entity.ClazzEntity;
import net.sf.json.JSONArray;

/**
 * Created by LinXu on 2017/3/9.
 */
public interface AdminBiz {
    void setAllClass();
    JSONArray setAllStuData(Integer classId);
    boolean addClass(ClazzEntity clazzEntity);
    boolean updateClass(ClazzEntity clazzEntity);
    boolean delClass(Integer cid);
}
