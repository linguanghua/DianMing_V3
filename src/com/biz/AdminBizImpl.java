package com.biz;

import com.dao.ClassDao;
import com.dao.StuDao;
import com.entity.ClazzEntity;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by LinXu on 2017/3/9.
 */
@Service("adminBiz")
public class AdminBizImpl implements AdminBiz {
    @Resource(name = "classDao")
    private ClassDao classDao;

    public void setClassDao(ClassDao classDao) {
        this.classDao = classDao;
    }
    @Resource(name = "stuDao")
    private StuDao stuDao;

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    public void setAllClass() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        List<ClazzEntity> list = classDao.getAllClass();
        if(list!=null&&!list.isEmpty()){
            session.put("allClass",list);
        }
    }

    @Override
    public JSONArray setAllStuData(Integer classId) {
        JSONArray array = null;
        List<User> list = stuDao.getStudentInfo(classId);
        if (list!=null&&!list.isEmpty()){
             array = JSONArray.fromObject(list);
            System.out.println(array);
        }
        return array;
    }

    @Override
    public boolean addClass(ClazzEntity clazzEntity) {

        return classDao.addClass(clazzEntity);
    }

    @Override
    public boolean updateClass(ClazzEntity clazzEntity) {
        return classDao.updateClass(clazzEntity);
    }

    @Override
    public boolean delClass(Integer cid) {
        return classDao.delClass(cid);
    }
}
