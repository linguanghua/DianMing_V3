package com.impl;

import com.dao.StuDao;
import com.entity.ClazzEntity;
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
@Repository("stuDao")
public class StuDaoImpl implements StuDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getStudentInfo(Integer classId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = null;
        try{
            String sql = "select u from  User as u, Selectlesson as s " +
                    "where s.classId=? AND s.userId=u.username order by u.username asc";
            Query query = session.createQuery(sql);
            query.setParameter(0,classId);
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
    public List<ClazzEntity> getAllClass() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<ClazzEntity> list = null;
        try{
            String sql = "from  ClazzEntity as c ";
            Query query = session.createQuery(sql);
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
