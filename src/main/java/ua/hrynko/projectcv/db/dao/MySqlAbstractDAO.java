package ua.hrynko.projectcv.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.hrynko.projectcv.db.dao.interfaces.AbstractDAO;
import java.util.List;
@Repository
public abstract class  MySqlAbstractDAO<T> implements AbstractDAO<T> {

    @Autowired
    protected SessionFactory sessionFactory;
    protected Class aClass;
    protected String tableName;

    @Override
    public void save(T obj) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
        }
    }

    @Override
    public void update(T obj) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
        }
    }

    @Override
    public void delete(T obj) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        }
    }

    @Override
    public T getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return (T) session.get(aClass, id);
        }
    }

    @Override
    public List<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from " + tableName);
            return query.list();
        }
    }
}



