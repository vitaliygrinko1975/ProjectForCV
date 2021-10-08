package ua.hrynko.projectcv.db.dao;


import org.springframework.stereotype.Repository;
import ua.hrynko.projectcv.db.dao.interfaces.OrderDAO;
import ua.hrynko.projectcv.db.models.Orders;

import javax.persistence.Entity;

@Repository
public class MySqlOrdersDAO extends MySqlAbstractDAO<Orders> implements OrderDAO {

        public MySqlOrdersDAO() {
        aClass = Orders.class;
        tableName = Orders.class.getAnnotation(Entity.class).name();
    }

}
