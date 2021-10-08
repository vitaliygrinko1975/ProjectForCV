package ua.hrynko.projectcv.db.dao;



import org.springframework.stereotype.Repository;
import ua.hrynko.projectcv.db.dao.interfaces.OrdersCarsDAO;
import ua.hrynko.projectcv.db.models.OrdersCars;


import javax.persistence.Entity;

@Repository
public class MySqlOrdersCarsDAO extends MySqlAbstractDAO<OrdersCars> implements OrdersCarsDAO {

    public MySqlOrdersCarsDAO() {
        aClass = OrdersCars.class;
        tableName = OrdersCars.class.getAnnotation(Entity.class).name();
    }


}
