package ua.hrynko.projectcv.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.hrynko.projectcv.db.dao.interfaces.UserDAO;
import ua.hrynko.projectcv.db.models.Roles;
import ua.hrynko.projectcv.db.models.Users;

import javax.persistence.Entity;
import java.util.List;


@Repository
public class MySqlUsersDAO extends MySqlAbstractDAO<Users>  implements UserDAO {

    public MySqlUsersDAO() {
        aClass = Users.class;
        tableName = Users.class.getAnnotation(Entity.class).name();
    }

    public void addClientToUsersDb(String login, String password, String firstName, String lastName) {
        Users user = new Users();
        Roles role = new Roles();
        role.setId(2);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.getTransaction();
        t.begin();
        try {
            session.saveOrUpdate(user);
            // LOG.trace("add client to SQL succesful--> ");
        } catch (Exception e) {
            //  LOG.trace("ERRor--> ");
            t.rollback();

        }
        t.commit();
    }

    public void addAdminToUsersDb(String login, String password, String firstName, String lastName) {
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setId(1);
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.getTransaction();
        t.begin();
        try {
            session.saveOrUpdate(user);
//            LOG.trace("add admin to SQL succesful--> ");
        } catch (Exception e) {
//            LOG.trace("ERRor--> ");
            t.rollback();

        }
        t.commit();
    }


    public Users findUserByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            Criteria c = session.createCriteria(Users.class);
            c.add(Restrictions.eq("login", login));
            return (Users) c.uniqueResult();
        }
    }



    public List<Users> findAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from " + tableName);
            return query.list();
        }

    }

}