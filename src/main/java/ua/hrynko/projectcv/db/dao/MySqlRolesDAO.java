package ua.hrynko.projectcv.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ua.hrynko.projectcv.db.dao.interfaces.RoleDAO;
import ua.hrynko.projectcv.db.models.Roles;

import javax.persistence.Entity;

@Repository
public class MySqlRolesDAO extends MySqlAbstractDAO<Roles> implements RoleDAO {
        public MySqlRolesDAO() {
        aClass = Roles.class;
        tableName = Roles.class.getAnnotation(Entity.class).name();
    }

    @Override
    public Roles findRoleByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Criteria c = session.createCriteria(Roles.class);
            c.add(Restrictions.eq("name", name));
            return (Roles) c.uniqueResult();
        }
    }

  }

