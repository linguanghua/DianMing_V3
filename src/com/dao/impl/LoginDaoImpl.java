package com.dao.impl;

import com.dao.LoginDao;
import com.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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
    public String login(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            String sql = "select count(*) from User u where u.username=? and u.password=?";
            Query query = session.createQuery(sql);
            query.setParameter(0, user.getUsername());
            query.setParameter(1,user.getPassword());
            int len = ((Number)query.uniqueResult()).intValue();
            transaction.commit();

            if(len==1){
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return "error";
    }
}
