package ua.hrynko.projectcv.db.dao.interfaces;
import ua.hrynko.projectcv.db.models.Roles;


public interface RoleDAO extends AbstractDAO<Roles> {

    Roles findRoleByName(String name);
}