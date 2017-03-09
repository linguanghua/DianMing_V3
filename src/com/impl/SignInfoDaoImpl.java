package com.impl;

import com.dao.SignInfoDao;
import com.entity.StuSignInfo;
import com.entity.TeaSignInfo;
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

    @Override
    public List<TeaSignInfo> getTeaSignInfo(Integer classId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<TeaSignInfo> list = null;
        try{
            String sql = "select distinct  new com.entity.TeaSignInfo(u.username,u.name,sign.day," +
                    "sign.sign,c.lesson,c.week,c.className,c.classId) " +
                    "from Selectlesson as s,Signstatus as sign,User as u,ClazzEntity as c " +
                    "where s.classId = ? AND sign.classId=? AND c.classId=? " +
                    "AND u.username = sign.stuId AND c.lesson =sign.lesson " +
                    " order by sign.day,c.week,c.lesson,u.username asc";
            Query query = session.createQuery(sql);
            query.setParameter(0, classId);
            query.setParameter(1, classId);
            query.setParameter(2, classId);
            list = query.list();
            transaction.commit();
            for (TeaSignInfo t: list
                    ) {
                System.out.println(t.getClassName()+" "+t.getStuName());
            }
            System.out.println(list.size());
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
        return list;
    }

    @Override
    public List<Integer> getTClassId(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Integer> list = null;
        try{
            String sql = "select c.classId from Selectlesson as s,ClazzEntity as c " +
                         "where s.userId = ? AND c.classId=s.classId   " +
                         "order by c.week,c.lesson asc";
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
