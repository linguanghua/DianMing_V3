package com.impl;

import com.dao.SignInfoDao;
import com.entity.StuSignInfo;
import com.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LinXu on 2017/3/9.
 */
@Repository("signInfoDao")
public class SignInfoDaoImpl implements SignInfoDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<StuSignInfo> getStuSignData(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<StuSignInfo> list = null;
        try{
            String sql = "select new com.entity.StuSignInfo(sign.day,sign.sign,c.className,c.week,c.lesson)" +
                    "from Signstatus as sign,ClazzEntity as c " +
                    "where sign.stuId=? and c.classId = sign.classId AND c.lesson = sign.lesson " +
                    "order by sign.day,c.week,c.lesson asc";
            Query query = session.createQuery(sql);
            query.setParameter(0, user.getUsername());
            list = query.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
        return list;
    }

}
