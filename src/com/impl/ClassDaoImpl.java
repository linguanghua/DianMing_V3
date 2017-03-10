package com.impl;

import com.dao.ClassDao;
import com.entity.ClazzEntity;
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
@Repository("classDao")
public class ClassDaoImpl implements ClassDao {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<ClazzEntity> getAllClass() {
        List<ClazzEntity> list = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            String sql = "from ClazzEntity c";
            Query query = session.createQuery(sql);
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addClass(ClazzEntity clazzEntity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            String sql = "INSERT INTO class (classId, className, classRoom,week,lesson) " +
                    "SELECT '" + clazzEntity.getClassId() + "','" + clazzEntity.getClassName() + "','" + clazzEntity.getClassRoom() + "','" + clazzEntity.getWeek() + "','" + clazzEntity.getLesson() + "' " +
                    "FROM dual " +
                    "WHERE not exists (select * from class where classId = '" + clazzEntity.getClassId() + "' AND lesson='" + clazzEntity.getLesson() + "')";
                    Query query = session.createSQLQuery(sql);
                    int n = query.executeUpdate();
            if(n>0)
                return true;
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateClass(ClazzEntity clazzEntity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            String sql = "update class set className='" + clazzEntity.getClassName() + "',classRoom='" + clazzEntity.getClassRoom() + "',week='" + clazzEntity.getWeek()  + "',lesson='" + clazzEntity.getLesson()  + "' " +
                    "where classId='" + clazzEntity.getClassId()  + "'";
            Query query = session.createSQLQuery(sql);
            int n = query.executeUpdate();
            if(n>0)
                return true;
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delClass(Integer cid) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            String sql = "delete from class where classId = '" + cid + "'";
            Query query = session.createSQLQuery(sql);
            int n = query.executeUpdate();
            transaction.commit();
            if(n>0)
                return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return false;
    }
}
