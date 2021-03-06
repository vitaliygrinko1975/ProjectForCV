package ua.hrynko.projectcv.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.hrynko.projectcv.db.dao.interfaces.CarsDAO;
import ua.hrynko.projectcv.db.models.Cars;
import javax.persistence.Entity;
import java.util.List;


@Repository
public class MySqlCarsDAO extends MySqlAbstractDAO<Cars> implements CarsDAO {

        public MySqlCarsDAO() {
        aClass = Cars.class;
        tableName = Cars.class.getAnnotation(Entity.class).name();
    }



    @Override
    public List<Cars> findCars(){
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from " + tableName);
            return query.list();
        }
    }



    @Override
    public Cars findCarToCarsDb(int id)  throws NullPointerException{
        try (Session session = sessionFactory.openSession()) {
            return  (Cars) session.get(aClass, id);
        }
    }


    public List<Cars> selectCarsByCategory(String selectableCategory) throws NullPointerException{

        try (Session session = sessionFactory.openSession()) {
            Criteria cr = session.createCriteria(aClass);
            cr.add(Restrictions.like("category", "%" + selectableCategory + "%"));
            return cr.list();
        }
    }

    public List<Cars> findCarSortedUpByName()  throws NullPointerException{
        try (Session session = sessionFactory.openSession()) {
            Criteria cr = session.createCriteria(aClass);
            cr.addOrder(Order.asc("name"));
            return cr.list();
        }
    }

    public List<Cars> findCarSortedDownByName()  throws NullPointerException {
        try (Session session = sessionFactory.openSession()) {
            Criteria cr = session.createCriteria(aClass);
            cr.addOrder(Order.desc("name"));
            return cr.list();
        }
    }
}


