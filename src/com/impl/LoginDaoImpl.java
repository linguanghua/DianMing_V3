package com.impl;

import com.dao.LoginDao;
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
 * Created by LinXu on 2017/3/8.
 */
@Repository("loginDao")
public class LoginDaoImpl implements LoginDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> login(User user) {
        List<User> list = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            String sql = "from User u where u.username=? and u.password=?";
            Query query = session.createQuery(sql);
            query.setParameter(0, user.getUsername());
            query.setParameter(1,user.getPassword());
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
    public List<ClazzEntity> getClasses(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<ClazzEntity> list = null;
        String sql = "select c from User u,ClazzEntity as c,Selectlesson as s "+
        "where s.userId = ?  and u.username = ? and c.classId = s.classId " +
                " order by c.week,c.lesson asc";
        try{
            Query query = session.createQuery(sql);
            query.setParameter(0, user.getUsername());
            query.setParameter(1,user.getUsername());
            list = query.list();
            transaction.commit();
        } catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
                session.close();
        }
        return list;
    }

}
