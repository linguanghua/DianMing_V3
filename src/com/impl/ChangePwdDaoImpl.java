package com.impl;

import com.dao.ChangePwdDao;
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
@Repository("changePwdDao")
public class ChangePwdDaoImpl implements ChangePwdDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean changePwd(User user,String pwd) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try{
            String sql = "update User u set u.password=? where u.username=?";
            Query query = session.createQuery(sql);
            query.setParameter(0, pwd);
            query.setParameter(1, user.getUsername());
            int r = query.executeUpdate();
            transaction.commit();
            if(r==1){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            session.close();
        }
        return false;
    }
}
