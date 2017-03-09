package com.biz;

import com.dao.LoginDao;
import com.dao.SignInfoDao;
import com.entity.*;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Resource(name = "signInfoDao")
    private SignInfoDao signInfoDao;

    public void setSignInfoDao(SignInfoDao signInfoDao) {
        this.signInfoDao = signInfoDao;
    }

    @Override
    public boolean login(User user) {
        List<User> ulist = loginDao.login(user);
        Map<String, Object> session = ActionContext.getContext().getSession();
        if(ulist.size()==1) {
            session.put("user",ulist.get(0));
            setDatas(ulist.get(0));
            setSignData(ulist.get(0));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void setDatas(User user) {
        Map<String, Object> session = ActionContext.getContext().getSession();
        List<ClazzEntity> list = loginDao.getClasses(user);
        if (list != null) {
            String classes[][]=  formatData(list);
            session.put("classes", classes);
        }
    }

    @Override
    public void setSignData(User user) {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if(user.getUserType()==0){
            List<StuSignInfo> list = signInfoDao.getStuSignData(user);
            if(list!=null){
                session.put("stuSignInfo",list);
            }
        }if(user.getUserType()==1){
            List<Integer> list = signInfoDao.getTClassId(user);
            List<DataList> lists = new ArrayList<DataList>();
            for ( Integer i:list
                 ) {
                List<TeaSignInfo> tlist = signInfoDao.getTeaSignInfo(i);
                DataList dlist = new DataList(tlist.get(0).getClassName(),tlist);
                lists.add(dlist);
            }
            session.put("taeSignInfo",lists);
        }

    }

    private String[][] formatData(List<ClazzEntity> clist){
        String [][] lession = new String[8][];
        String[] time = new String[]{  "08:00-09:40", "10:00-11:40", "12:00-13:40", "14:00-15:40",
                "16:00-17:40", "18:00-19:40", "20:00-21:40"};

        for(int i=0;i<7;i++){
             lession[i] = new String[6];
            lession[i][0] = time[i];
            for (int j = 1; j <6; j++) {
                lession[i][j] = "";
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 1; j <6 ; j++) {
                for (ClazzEntity c:clist
                     ) {
                    if(c.getLesson()==(i+1)&&c.getWeek()==j) {
                        lession[i][j] = c.getClassName()+"<br />"+c.getClassRoom();
                    }
                }
            }
        }
        return lession;
    }
}
